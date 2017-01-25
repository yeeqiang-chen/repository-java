package com.yiqiang.repository.javase.thread.customization.chapter06;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinWorkerThread;

/**
 * Title:
 * Description:
 * Factory to be used by the Fork/Join framework to create the worker threads. Implements
 * the ForkJoinWorkerThreadFactory interface
 * Create Time: 2017/1/22 0022 23:29
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class MyWorkerThreadFactory implements ForkJoinPool.ForkJoinWorkerThreadFactory {

    /**
     * Method that creates a worker thread for the Fork/Join framework
     * @param pool ForkJoinPool where the thread will be executed
     * @return a MyWorkerThread thread
     */
    @Override
    public ForkJoinWorkerThread newThread(ForkJoinPool pool) {
        return new MyWorkerThread(pool);
    }

}
