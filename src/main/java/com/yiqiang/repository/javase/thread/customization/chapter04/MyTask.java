package com.yiqiang.repository.javase.thread.customization.chapter04;

import java.util.concurrent.TimeUnit;

/**
 * Title:
 * Description:
 * Task to check the MyThread and MyThreadFactory classes. It sleeps
 * the thread for two seconds
 * Create Time: 2017/1/22 0022 23:19
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class MyTask implements Runnable {

    /**
     * Main method of the task. It sleeps the thread for two seconds
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
