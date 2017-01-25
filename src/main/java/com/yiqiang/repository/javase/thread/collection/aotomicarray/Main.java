package com.yiqiang.repository.javase.thread.collection.aotomicarray;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Title:
 * Description:
 * Main class of the example. Execute 100 incrementers and 100 decrementers
 * and checks that the results are the expected
 * Create Time: 2017/1/21 0021 16:41
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class Main {
    /**
     * @param args
     */
    public static void main(String[] args) {

        final int THREADS=100;
        /**
         * Atomic array whose elements will be incremented and decremented
         */
        AtomicIntegerArray vector=new AtomicIntegerArray(1000);
		/*
		 * An incrementer task
		 */
        Incrementer incrementer=new Incrementer(vector);
		/*
		 * A decrementer task
		 */
        Decrementer decrementer=new Decrementer(vector);

		/*
		 * Create and execute 100 incrementer and 100 decrementer tasks
		 */
        Thread threadIncrementer[]=new Thread[THREADS];
        Thread threadDecrementer[]=new Thread[THREADS];
        for (int i=0; i<THREADS; i++) {
            threadIncrementer[i]=new Thread(incrementer);
            threadDecrementer[i]=new Thread(decrementer);

            threadIncrementer[i].start();
            threadDecrementer[i].start();
        }

		/*
		 * Wait for the finalization of all the tasks
		 */
        for (int i=0; i<THREADS; i++) {
            try {
                threadIncrementer[i].join();
                threadDecrementer[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

		/*
		 * Write the elements different from 0
		 */
        for (int i=0; i<vector.length(); i++) {
            if (vector.get(i)!=0) {
                System.out.println("Vector["+i+"] : "+vector.get(i));
            }
        }

        System.out.println("Main: End of the example");
    }
}
