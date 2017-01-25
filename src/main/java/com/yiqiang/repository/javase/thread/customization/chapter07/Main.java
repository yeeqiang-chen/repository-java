package com.yiqiang.repository.javase.thread.customization.chapter07;

import java.util.concurrent.ForkJoinPool;

/**
 * Title:
 * Description:
 * Main class of the example. It creates a ForkJoinPool and a
 * Task and executes the task in the pool
 * Create Time: 2017/1/22 0022 23:32
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class Main {
    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {

		/*
		 * Create an array of 10000 elements
		 */
        int array[]=new int[10000];

		/*
		 * ForkJoinPool to execute the task
		 */
        ForkJoinPool pool=new ForkJoinPool();

		/*
		 * Task to increment the elements of the array
		 */
        Task task=new Task("Task",array,0,array.length);

		/*
		 * Send the task to the pool
		 */
        pool.invoke(task);

		/*
		 * Shutdown the pool
		 */
        pool.shutdown();

		/*
		 * Write a message in the console
		 */
        System.out.printf("Main: End of the program.\n");

    }
}
