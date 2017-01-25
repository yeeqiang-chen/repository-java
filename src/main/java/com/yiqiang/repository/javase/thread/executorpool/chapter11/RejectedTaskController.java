package com.yiqiang.repository.javase.thread.executorpool.chapter11;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Title:
 * Description:
 * This class implements the handler for the rejected tasks. Implements
 * the RejectedExecutionHandler interface and will be called for each task
 * sent to an executor after it was finished using the shutdown() method
 * Create Time: 2017/1/20 0020 2:29
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class RejectedTaskController implements RejectedExecutionHandler {

    /**
     * Method that will be executed for each rejected task
     * @param r Task that has been rejected
     * @param executor Executor that has rejected the task
     */
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.printf("RejectedTaskController: The task %s has been rejected\n",r.toString());
        System.out.printf("RejectedTaskController: %s\n",executor.toString());
        System.out.printf("RejectedTaskController: Terminating: %s\n",executor.isTerminating());
        System.out.printf("RejectedTaksController: Terminated: %s\n",executor.isTerminated());
    }

}
