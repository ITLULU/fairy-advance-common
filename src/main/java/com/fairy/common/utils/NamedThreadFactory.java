package com.fairy.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hll
 * @version 1.0
 * @date 2022/6/26 17:53
 */
public class NamedThreadFactory implements ThreadFactory {

    /**
     * 原子操作保证每个线程都有唯一的
     */
    private static final AtomicInteger threadNumber = new AtomicInteger(1);

    private final AtomicInteger mThreadNum = new AtomicInteger(1);

    private final String prefix;

    private final boolean daemoThread;

    private final ThreadGroup threadGroup;

    public NamedThreadFactory() {
        this("rpcserver-threadpool-" + threadNumber.getAndIncrement(), false);
    }

    public NamedThreadFactory(String prefix) {
        this(prefix, false);
    }


    public NamedThreadFactory(String prefix, boolean daemo) {
        this.prefix = StringUtils.isNotEmpty(prefix) ? prefix + "-thread-" : "";
        daemoThread = daemo;
        SecurityManager s = System.getSecurityManager();
        threadGroup = (s == null) ? Thread.currentThread().getThreadGroup() : s.getThreadGroup();
    }

    @Override
    public Thread newThread(Runnable runnable) {
        String name = prefix + mThreadNum.getAndIncrement();
        Thread ret = new Thread(threadGroup, runnable, name, 0);
        ret.setDaemon(daemoThread);
        return ret;
    }
}