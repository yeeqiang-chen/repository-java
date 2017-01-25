package com.yiqiang.repository.javase.thread.customization.chapter03;

import java.util.concurrent.TimeUnit;

/**
 * Title:
 * Description: Task to be executed in the MyThread threads
 * Create Time: 2017/1/22 0022 23:13
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class MyTask implements Runnable {

    /**
     * Main method of the Thread. Sleeps the thread during two seconds
     */
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
