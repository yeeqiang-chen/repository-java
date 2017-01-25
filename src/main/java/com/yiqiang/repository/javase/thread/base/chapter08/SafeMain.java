package com.yiqiang.repository.javase.thread.base.chapter08;

import java.util.concurrent.TimeUnit;

/**
 * Title:
 * Description:
 *  Main class of the example.
 * Create Time: 2017/1/16 0016 22:13
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class SafeMain {

    /**
     * Main method of the example
     * @param args
     */
    public static void main(String[] args) {
        // Creates a task
        SafeTask task=new SafeTask();

        // Creates and start three Thread objects for that Task
        for (int i=0; i<3; i++){
            Thread thread=new Thread(task);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            thread.start();
        }

    }
}
