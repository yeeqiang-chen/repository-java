package com.yiqiang.repository.javase.thread.executorpool.chapter01;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Title:
 * Description: This class implements a concurrent task
 * Create Time: 2017/1/19 0019 2:05
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class Task implements Runnable {

    /**
     * The start date of the task
     */
    private Date initDate;
    /**
     * The name of the task
     */
    private String name;

    /**
     * Constructor of the class. Initializes the name of the task
     * @param name name asigned to the task
     */
    public Task(String name){
        initDate=new Date();
        this.name=name;
    }

    /**
     * This method implements the execution of the task. Waits a random period of time and finish
     */
    @Override
    public void run() {
        System.out.printf("%s: Task %s: Created on: %s\n",Thread.currentThread().getName(),name,initDate);
        System.out.printf("%s: Task %s: Started on: %s\n",Thread.currentThread().getName(),name,new Date());

        try {
            Long duration=(long)(Math.random()*10);
            System.out.printf("%s: Task %s: Doing a task during %d seconds\n",Thread.currentThread().getName(),name,duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("%s: Task %s: Finished on: %s\n",Thread.currentThread().getName(),name,new Date());
    }

}

/**
 * 仅当线程的数量是合理的或者线程只会运行很短的时间时,适合使用Executors工厂类的newCachedThreadPool()方法来创建执行器
 */