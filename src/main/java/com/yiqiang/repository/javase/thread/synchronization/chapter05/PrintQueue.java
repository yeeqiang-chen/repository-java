package com.yiqiang.repository.javase.thread.synchronization.chapter05;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Title:
 * Description: This class simulates a print queue
 * Create Time: 2017/1/17 0017 0:26
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class PrintQueue {

    /**
     * Lock to control the access to the queue.
     */
    private final Lock queueLock=new ReentrantLock();

    /**
     * Method that prints a document
     * @param document document to print
     */
    public void printJob(Object document){
        queueLock.lock();

        try {
            Long duration=(long)(Math.random()*10000);
            System.out.printf("%s: PrintQueue: Printing a Job during %d seconds\n",Thread.currentThread().getName(),(duration/1000));
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            queueLock.unlock();
        }
    }
}
