package com.yiqiang.repository.javase.thread.executorpool.chapter08;

import java.util.concurrent.Callable;

/**
 * Title:
 * Description:
 * This class implements the task of the example. It simply writes a message
 * to the console every 100 milliseconds
 * Create Time: 2017/1/20 0020 2:16
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class Task implements Callable<String> {

    /**
     * Main method of the task. It has an infinite loop that writes a message to
     * the console every 100 milliseconds
     */
    @Override
    public String call() throws Exception {
        while (true){
            System.out.printf("Task: Test\n");
            Thread.sleep(100);
        }
    }
}
