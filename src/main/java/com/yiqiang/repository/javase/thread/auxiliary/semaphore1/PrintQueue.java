package com.yiqiang.repository.javase.thread.auxiliary.semaphore1;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Title:
 * Description:
 * This class implements the PrintQueue using a Semaphore to control the access to it.
 * Create Time: 2017/1/17 0017 1:46
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class PrintQueue {

    /**
     * Semaphore to control the access to the queue
     */
    private final Semaphore semaphore;

    /**
     * Constructor of the class. Initializes the semaphore
     */
    public PrintQueue(){
        semaphore=new Semaphore(1);
    }

    /**
     * Method that simulates printing a document
     * @param document Document to print
     */
    public void printJob (Object document){
        try {
            // Get the access to the semaphore. If other job is printing, this
            // thread sleep until get the access to the semaphore
            semaphore.acquire();

            Long duration=(long)(Math.random()*10);
            System.out.printf("%s: PrintQueue: Printing a Job during %d seconds\n",Thread.currentThread().getName(),duration);
            Thread.sleep(duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Free the semaphore. If there are other threads waiting for this semaphore,
            // the JVM selects one of this threads and give it the access.
            semaphore.release();
        }
    }
}