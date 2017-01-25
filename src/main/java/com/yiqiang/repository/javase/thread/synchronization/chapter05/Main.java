package com.yiqiang.repository.javase.thread.synchronization.chapter05;

/**
 * Title:
 * Description: Main class of the example.
 * Create Time: 2017/1/17 0017 0:26
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class Main {

    /**
     * Main method of the class. Run ten jobs in parallel that
     * send documents to the print queue at the same time.
     */
    public static void main (String args[]){

        // Creates the print queue
        PrintQueue printQueue=new PrintQueue();

        // Creates ten Threads
        Thread thread[]=new Thread[10];
        for (int i=0; i<10; i++){
            thread[i]=new Thread(new Job(printQueue),"Thread "+i);
        }

        // Starts the Threads
        for (int i=0; i<10; i++){
            thread[i].start();
        }
    }
}

/**
 * Java提供了同步代码块的另外一种机制,它就是比synchronized关键字更强大也更灵活的机制.
 * 这种机制基于Lock接口及其实现类(例如ReentrantLock)
 *
 * tryLock(),试图获取锁,如果锁已经被其他线程获取,它将返回false,并继续往下执行代码
 * 跟lock()放最大的不同是:线程使用tryLock()不能狗获取锁,tryLock()会立即返回,它不会将线程置入休眠
 *
 */