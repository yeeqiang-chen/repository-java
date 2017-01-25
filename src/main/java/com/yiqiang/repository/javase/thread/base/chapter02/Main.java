package com.yiqiang.repository.javase.thread.base.chapter02;

import java.util.concurrent.TimeUnit;


/**
 * Title:
 * Description:
 * Main class of the sample. Launch the PrimeGenerator, waits
 * five seconds and interrupts the Thread
 * Create Time: 2017/1/16 0016 2:54
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class Main {

    /**
     * Main method of the sample. Launch the PrimeGenerator, waits
     * five seconds and interrupts the Thread
     *
     * @param args
     */
    public static void main(String[] args) {

        // Launch the prime numbers generator
        Thread task = new PrimeGenerator();
        task.start();

        // Wait 5 seconds
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Interrupt the prime number generator
        task.interrupt();
    }

}

//=======================================================================
/**
 * isInterrupted()和interrupted()方法有一个很大的区别.
 * isInterrupted()不能改变interrupted属性的值,但是后者能设置interrupted属性为false
 * 因为interrupted()是一个静态方法,更推荐使用isInterrupted()方法
 */

//=======================================================================
