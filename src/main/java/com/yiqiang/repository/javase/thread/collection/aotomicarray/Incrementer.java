package com.yiqiang.repository.javase.thread.collection.aotomicarray;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Title:
 * Description: This task implements an incrementer. It increments by 1
 * all the elements of an array
 * Create Time: 2017/1/21 0021 16:41
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class Incrementer implements Runnable {

    /**
     * Array that store the elements to increment
     */
    private AtomicIntegerArray vector;

    /**
     * Constructor of the class
     * @param vector Array to store the elements to increment
     */
    public Incrementer(AtomicIntegerArray vector) {
        this.vector=vector;
    }

    /**
     * Main method of the task. Increment all the elements of the
     * array
     */
    @Override
    public void run() {

        for (int i=0; i<vector.length(); i++){
            vector.getAndIncrement(i);
        }

    }

}
