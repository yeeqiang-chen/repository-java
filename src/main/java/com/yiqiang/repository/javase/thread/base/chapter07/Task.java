package com.yiqiang.repository.javase.thread.base.chapter07;

/**
 * Title:
 * Description:
 *  Runnable class than throws and Exception
 * Create Time: 2017/1/16 0016 22:01
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class Task implements Runnable {


    /**
     * Main method of the class
     */
    @Override
    public void run() {
        // The next instruction always throws and exception
        int numero=Integer.parseInt("TTT");
    }

}
