package com.yiqiang.repository.javase.thread.base.chapter05;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Title:
 * Description:
 *  Class that simulates an initialization operation. It sleeps during four seconds
 * Create Time: 2017/1/16 0016 3:30
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class DataSourcesLoader implements Runnable {


    /**
     * Main method of the class
     */
    @Override
    public void run() {

        // Writes a messsage
        System.out.printf("Begining data sources loading: %s\n",new Date());
        // Sleeps four seconds
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Writes a message
        System.out.printf("Data sources loading has finished: %s\n",new Date());
    }
}