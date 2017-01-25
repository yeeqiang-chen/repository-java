package com.yiqiang.repository.javase.thread.base.chapter09;

import java.util.concurrent.TimeUnit;

/**
 * Title:
 * Description:
 * Create Time: 2017/1/16 0016 22:26
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class Main {

    /**
     * Main class of the example
     * @param args
     */
    public static void main(String[] args) {

        // Create a ThreadGroup
        ThreadGroup threadGroup = new ThreadGroup("Searcher");
        Result result=new Result();

        // Create a SeachTask and 10 Thread objects with this Runnable
        SearchTask searchTask=new SearchTask(result);
        for (int i=0; i<5; i++) {
            Thread thread=new Thread(threadGroup, searchTask);
            thread.start();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Write information about the ThreadGroup to the console
        System.out.printf("Number of Threads: %d\n",threadGroup.activeCount());
        System.out.printf("Information about the Thread Group\n");
        threadGroup.list(); // 通过list()方法打印线程组对象的信息

        // Write information about the status of the Thread objects to the console
        Thread[] threads=new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
        for (int i=0; i<threadGroup.activeCount(); i++) {
            System.out.printf("Thread %s: %s\n",threads[i].getName(),threads[i].getState());
        }

        // Wait for the finalization of the Threadds
        waitFinish(threadGroup);

        // Interrupt all the Thread objects assigned to the ThreadGroup
        threadGroup.interrupt();
    }

    /**
     * Method that waits for the finalization of one of the ten Thread objects
     * assigned to the ThreadGroup
     * @param threadGroup
     */
    private static void waitFinish(ThreadGroup threadGroup) {
        while (threadGroup.activeCount()>9) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 线程组类存储了线程对象和关联的线程组对象,并可以访问它们的信息(例如状态),
 * 将执行的操作应用到所有成员上(例如中断)
 * activeCount()方法获取线程组包含的线程数目
 * enumerate()方法获取线程组包含的线程列表
 */