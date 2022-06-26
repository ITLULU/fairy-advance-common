package com.fairy.common.utils;
import java.util.concurrent.*;

/**
 * @author 鹿少年
 * @version 1.0
 * @project fourth-class
 * @createTime 2022/3/19 17:05
 */
public class ThreadPoolUtils {

    public static ThreadPoolExecutor createThreadPool(int corePoolSize,
                                                      int maximumPoolSize,
                                                      Long keepAliveTime,
                                                      BlockingQueue workQueue,
                                                      ThreadFactory factory,
                                                      RejectedExecutionHandler handler) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime,
                TimeUnit.MILLISECONDS, workQueue,factory, handler);
        // 提前创建好核心线程
        threadPoolExecutor.prestartAllCoreThreads();
        // 常驻核心线程的空闲时间超过 keepAliveTime 的时候要被回收
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

}
