package com.yiqiang.repository.javase.thread.executorpool.chapter06;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * Title:
 * Description:
 * This class implements the task of this example. Writes a
 * message to the console with the actual date and returns the
 * 'Hello, world' string
 * Create Time: 2017/1/20 0020 2:09
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class Task implements Callable<String> {

    /**
     * Name of the task
     */
    private String name;

    /**
     * Constructor of the class
     * @param name Name of the task
     */
    public Task(String name) {
        this.name=name;
    }

    /**
     * Main method of the task. Writes a message to the console with
     * the actual date and returns the 'Hello world' string
     */
    @Override
    public String call() throws Exception {
        System.out.printf("%s: Starting at : %s\n",name,new Date());
        return "Hello, world";
    }

}
