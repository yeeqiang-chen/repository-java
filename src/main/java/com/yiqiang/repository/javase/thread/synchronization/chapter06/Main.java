package com.yiqiang.repository.javase.thread.synchronization.chapter06;

/**
 * Title:
 * Description: Main class of the example
 * Create Time: 2017/1/17 0017 0:40
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

        // Creates an object to store the prices
        PricesInfo pricesInfo=new PricesInfo();

        Reader readers[]=new Reader[5];
        Thread threadsReader[]=new Thread[5];

        // Creates five readers and threads to run them
        for (int i=0; i<5; i++){
            readers[i]=new Reader(pricesInfo);
            threadsReader[i]=new Thread(readers[i]);
        }

        // Creates a writer and a thread to run it
        Writer writer=new Writer(pricesInfo);
        Thread threadWriter=new Thread(writer);

        // Starts the threads
        for (int i=0; i<5; i++){
            threadsReader[i].start();
        }
        threadWriter.start();

    }

}

/**
 * ReadWriteLock,ReentrantReadWriteLock
 * 一个是读操作锁,另一个是写操作说.
 * 使用读操作锁时可以运行多个线程同时访问,但是使用写操作锁时只允许一个线程进行
 * 在一个线程执行写操作时,其他线程不能狗执行读操作
 *
 * 当你获取Lock接口的读锁时,不可以进行修改操作,否则将引起数据不一致的错误
 */