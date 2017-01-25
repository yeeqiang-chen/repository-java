package com.yiqiang.repository.javase.thread.synchronization.chapter04;

/**
 * Title:
 * Description: Main class of the example
 * Create Time: 2017/1/17 0017 0:14
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class Main {

    /**
     * Main method of the example
     */
    public static void main(String[] args) {

        // Creates an event storage
        EventStorage storage=new EventStorage();

        // Creates a Producer and a Thread to run it
        Producer producer=new Producer(storage);
        Thread thread1=new Thread(producer);

        // Creates a Consumer and a Thread to run it
        Consumer consumer=new Consumer(storage);
        Thread thread2=new Thread(consumer);

        // Starts the thread
        thread2.start();
        thread1.start();
    }
}

/**
 * Java在Object类中提供了wait(),notify(),notifyAll().
 * 线程可以在同步代码块中调用wait().如果在同步代码块之外调用wait()方法,
 * JVM将抛出IllegalMonitorStateException异常
 *
 * 当一个线程调用wait()方法时,JVM将这个线程置入休眠，并且释放控制这个同步代码块的对象,
 * 同时运行其他线程执行这个对象控制的其他代码块，
 * 为了唤醒这个线程,必须在这个对象控制的某个同步代码块中调用notify()或者notifyALL()方法
 */