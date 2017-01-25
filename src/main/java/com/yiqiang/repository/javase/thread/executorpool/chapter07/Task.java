package com.yiqiang.repository.javase.thread.executorpool.chapter07;

import java.util.Date;

/**
 * Title:
 * Description:
 * This class implements the task of the example. Writes a message to
 * the console with the actual date.
 *
 *  Is used to explain the utilization of an scheduled executor to
 *  execute tasks periodically
 * Create Time: 2017/1/20 0020 2:14
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class Task implements Runnable {

    /**
     * Name of the task
     */
    private String name;

    /**
     * Constructor of the class
     * @param name the name of the class
     */
    public Task(String name) {
        this.name=name;
    }

    /**
     * Main method of the example. Writes a message to the console with the actual
     * date
     */
    @Override
    public void run() {
        System.out.printf("%s: Executed at: %s\n",name,new Date());
    }

}
