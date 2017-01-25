package com.yiqiang.repository.javase.thread.synchronization.chapter08;

import com.yiqiang.repository.javase.thread.synchronization.chapter08.util.FileMock;

/**
 * Title:
 * Description:
 * Create Time: 2017/1/17 0017 1:07
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
        /**
         * Creates a simulated file with 100 lines
         */
        FileMock mock=new FileMock(101, 10);

        /**
         * Creates a buffer with a maximum of 20 lines
         */
        Buffer buffer=new Buffer(20);

        /**
         * Creates a producer and a thread to run it
         */
        Producer producer=new Producer(mock, buffer);
        Thread threadProducer=new Thread(producer,"Producer");

        /**
         * Creates three consumers and threads to run them
         */
        Consumer consumers[]=new Consumer[3];
        Thread threadConsumers[]=new Thread[3];

        for (int i=0; i<3; i++){
            consumers[i]=new Consumer(buffer);
            threadConsumers[i]=new Thread(consumers[i],"Consumer "+i);
        }

        /**
         * Strats the producer and the consumers
         */
        threadProducer.start();
        for (int i=0; i<3; i++){
            threadConsumers[i].start();
        }
    }

}

/**
 * 一个锁可能关联一个或者多个条件,这些条件通过Condition接口声明.目的是运行线程获取锁并且查看等待的某一个条件
 * 是否满足,如果不满足就挂起直到某个乡村唤醒它们.Condition接口提供了挂起线程和唤起线程的机制.
 *
 * 与锁绑定的所有条件对象都是通过Lock接口声明的newCondition()方法创建的.在使用条件的时候,
 * 必须获取这个条件绑定的锁,所以带条件的代码必须在调用Lock对象的lock()方法和unlock()方法之间
 *
 * 当线程调用条件的await()方法时,它将自动释放这个条件绑定的锁,其他某个线程可以获取这个锁并且执行相同的操作,
 * 后者执行这个锁保护的另一个临界区代码
 *
 * 当一个线程调用了条件的signal()或者signalAll()方法后,一个或者多个在该条件上挂起的线程将被唤醒,
 * 但这并不能保证让它们挂起的条件已经满足,所以必须在while循环中调用await(),在条件成立之前不能离开这个循环.
 * 如果条件不成立,将再次调用await()
 *
 * 因调用await()方法进入休眠的线程可呢个会被中断,所以必须处理InterruptedException异常.
 *
 * await(long time, TimeUnit unit)
 *
 * awaitUninterruptibly():它是不可中断的,这个线程将休眠直到其他某个线程调用了将它挂起的条件的signal()或signalAll()
 *
 * awaitUnitl(Date date)
 */








