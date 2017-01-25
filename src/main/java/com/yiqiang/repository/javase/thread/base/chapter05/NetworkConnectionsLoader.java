package com.yiqiang.repository.javase.thread.base.chapter05;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Title:
 * Description:
 *  Class that simulates an initialization operation. It sleeps during six seconds
 * Create Time: 2017/1/16 0016 3:31
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class NetworkConnectionsLoader implements Runnable {


    /**
     * Main method of the class
     */
    @Override
    public void run() {
        // Writes a message
        System.out.printf("Begining network connections loading: %s\n",new Date());
        // Sleep six seconds
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Writes a message
        System.out.printf("Network connections loading has finished: %s\n",new Date());
    }
}
