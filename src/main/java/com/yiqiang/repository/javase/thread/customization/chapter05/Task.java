package com.yiqiang.repository.javase.thread.customization.chapter05;

import java.util.concurrent.TimeUnit;

/**
 * Title:
 * Description: Runnable object to check the MyScheduledTask and MyScheduledThreadPoolExecutor classes.
 * Create Time: 2017/1/22 0022 23:24
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class Task implements Runnable {

    /**
     * Main method of the task. Writes a message, sleeps the current thread for two seconds and
     * writes another message
     */
    @Override
    public void run() {
        System.out.printf("Task: Begin.\n");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Task: End.\n");
    }

}

