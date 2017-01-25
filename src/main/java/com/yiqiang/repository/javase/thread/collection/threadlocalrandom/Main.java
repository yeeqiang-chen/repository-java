package com.yiqiang.repository.javase.thread.collection.threadlocalrandom;

/**
 * Title:
 * Description: Main class of the example. It creates three task and execute them
 * Create Time: 2017/1/21 0021 16:30
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class Main {
    /**
     * @param args
     */
    public static void main(String[] args) {

		/*
		 * Create an array to store the threads
		 */
        Thread threads[]=new Thread[3];

		/*
		 * Launch three tasks
		 */
        for (int i=0; i<threads.length; i++) {
            TaskLocalRandom task=new TaskLocalRandom();
            threads[i]=new Thread(task);
            threads[i].start();
        }

    }
}
