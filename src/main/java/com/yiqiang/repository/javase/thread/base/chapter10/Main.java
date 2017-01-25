package com.yiqiang.repository.javase.thread.base.chapter10;

/**
 * Title:
 * Description: Main class of the example
 * Create Time: 2017/1/16 0016 23:17
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class Main {

    /**
     * Main method of the example. Creates a group of threads of
     * MyThreadGroup class and two threads inside this group
     * @param args
     */
    public static void main(String[] args) {

        // Create a MyThreadGroup object
        MyThreadGroup threadGroup=new MyThreadGroup("MyThreadGroup");
        // Create a Taks object
        Task task=new Task();
        // Create and start two Thread objects for this Task
        for (int i=0; i<2; i++){
            Thread t=new Thread(threadGroup,task);
            t.start();
        }
    }
}
