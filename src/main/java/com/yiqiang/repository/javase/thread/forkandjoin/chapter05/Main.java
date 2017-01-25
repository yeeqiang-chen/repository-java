package com.yiqiang.repository.javase.thread.forkandjoin.chapter05;

import com.yiqiang.repository.javase.thread.forkandjoin.chapter05.task.SearchNumberTask;
import com.yiqiang.repository.javase.thread.forkandjoin.chapter05.utils.ArrayGenerator;
import com.yiqiang.repository.javase.thread.forkandjoin.chapter05.utils.TaskManager;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * Title:
 * Description: Main class of the program.
 * Create Time: 2017/1/20 0020 23:51
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class Main {
    /**
     * Main method of the example
     * @param args
     */
    public static void main(String[] args) {

        // Generate an array of 1000 integers
        ArrayGenerator generator=new ArrayGenerator();
        int array[]=generator.generateArray(1000);

        // Create a TaskManager object
        TaskManager manager=new TaskManager();

        // Create a ForkJoinPool with the default constructor
        ForkJoinPool pool=new ForkJoinPool();

        // Create a Task to process the array
        SearchNumberTask task=new SearchNumberTask(array,0,1000,5,manager);

        // Execute the task
        pool.execute(task);

        // Shutdown the pool
        pool.shutdown();


        // Wait for the finalization of the task
        try {
            pool.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Write a message to indicate the end of the program
        System.out.printf("Main: The program has finished\n");
    }
}
