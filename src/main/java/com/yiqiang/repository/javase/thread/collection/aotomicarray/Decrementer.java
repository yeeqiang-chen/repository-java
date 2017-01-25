package com.yiqiang.repository.javase.thread.collection.aotomicarray;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Title:
 * Description:
 * This task implements a decrementer. It decrements by 1 unit all the
 * elements of an array
 * Create Time: 2017/1/21 0021 16:42
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class Decrementer implements Runnable {

    /**
     * The array to decrement the elements
     */
    private AtomicIntegerArray vector;

    /**
     * Constructor of the class
     * @param vector The array to decrement is elements
     */
    public Decrementer(AtomicIntegerArray vector) {
        this.vector=vector;
    }

    /**
     * Main method of the class. It decrements all the elements of the
     * array
     */
    @Override
    public void run() {
        for (int i=0; i<vector.length(); i++) {
            vector.getAndDecrement(i);
        }
    }

}