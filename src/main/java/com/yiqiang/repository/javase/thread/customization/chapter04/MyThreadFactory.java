package com.yiqiang.repository.javase.thread.customization.chapter04;

import java.util.concurrent.ThreadFactory;

/**
 * Title:
 * Description: Factory to create our kind of threads. Implement the ThreadFactory interface.
 * Create Time: 2017/1/22 0022 23:20
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class MyThreadFactory implements ThreadFactory {

    /**
     * Attribute to store the number of threads created by the Factory
     */
    private int counter;

    /**
     * Prefix to use in the name of the threads created by the Factory
     */
    private String prefix;

    /**
     * Constructor of the class. Initializes its attributes
     * @param prefix Prefix to use in the name of the threads
     */
    public MyThreadFactory (String prefix) {
        this.prefix=prefix;
        counter=1;
    }

    /**
     * Method that create a new MyThread object to execute the Runnable
     * object that receives as parameter
     */
    @Override
    public Thread newThread(Runnable r) {
        MyThread myThread=new MyThread(r,prefix+"-"+counter);
        counter++;
        return myThread;
    }
}
