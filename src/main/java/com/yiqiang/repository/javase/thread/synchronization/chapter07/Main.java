package com.yiqiang.repository.javase.thread.synchronization.chapter07;

/**
 * Title:
 * Description: Main class of the example
 * Create Time: 2017/1/17 0017 0:50
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class Main {

    /**
     * Main method of the example
     * @param args
     */
    public static void main (String args[]){
        // Creates the print queue
        PrintQueue printQueue=new PrintQueue();

        // Cretes ten jobs and the Threads to run them
        Thread thread[]=new Thread[10];
        for (int i=0; i<10; i++){
            thread[i]=new Thread(new Job(printQueue),"Thread "+i);
        }

        // Launch a thread ever 0.1 seconds
        for (int i=0; i<10; i++){
            thread[i].start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * ReentrantLock和ReentrantReadWriteLock类的构造器都含有一个布尔参数fair,
 * 它允许你控制这两个类的行为.默认fair值是false,它称为非公平模式(Non-Fail Mode).
 * 在非公平模式下,当有很多线程在等待锁(ReentrantLock和ReentrantReadWriteLock)时,
 * 锁将选择它们中的一个来访问临界区,这个选择是没有任何约束的.
 * 如果fair值是true,则称为公平模式(Fail Mode).在公平模式下,当有很多线程在等待锁（ReentrantLock和ReentrantReadWriteLock)时,
 * 锁将选择它们中的一个来访问临界区,而且选择的是等待时间最长的
 *
 */