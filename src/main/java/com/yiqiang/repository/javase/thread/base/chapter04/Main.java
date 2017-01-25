package com.yiqiang.repository.javase.thread.base.chapter04;

import java.util.concurrent.TimeUnit;

/**
 * Title:
 * Description:
 *     Main class of the Example. Creates a FileClock runnable object
 *     and a Thread to run it. Starts the Thread, waits five seconds
 *     and interrupts it.
 * Create Time: 2017/1/16 0016 3:24
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class Main {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // Creates a FileClock runnable object and a Thread to run it
        FileClock clock=new FileClock();
        Thread thread=new Thread(clock);

        // Starts the Thread
        thread.start();
        try {
            // Waits five seconds
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        };
        // Interrupts the Thread
        thread.interrupt();
    }
}

/**
 * yield()方法只是做调试使用
 */
