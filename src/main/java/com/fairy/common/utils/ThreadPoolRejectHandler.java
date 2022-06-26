package com.fairy.common.utils;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author 鹿少年
 * @version 1.0
 * @date  2022/3/19 17:06
 */
public class ThreadPoolRejectHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        if (!executor.isShutdown()) {
            executor.getQueue().poll();
            executor.execute(r);
        }
    }
}