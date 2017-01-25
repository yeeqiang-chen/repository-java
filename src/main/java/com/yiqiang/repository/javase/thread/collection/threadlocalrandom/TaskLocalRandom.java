package com.yiqiang.repository.javase.thread.collection.threadlocalrandom;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Title:
 * Description: Task that generates random numbers
 * Create Time: 2017/1/21 0021 16:30
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class TaskLocalRandom implements Runnable {

    /**
     * Constructor of the class. Initializes the randoom number generator
     * for this task
     */
    public TaskLocalRandom() {
        ThreadLocalRandom.current();
    }

    /**
     * Main method of the class. Generate 10 random numbers and write them
     * in the console
     */
    @Override
    public void run() {
        String name=Thread.currentThread().getName();
        for (int i=0; i<10; i++){
            System.out.printf("%s: %d\n",name,ThreadLocalRandom.current().nextInt(10));
        }
    }

}
