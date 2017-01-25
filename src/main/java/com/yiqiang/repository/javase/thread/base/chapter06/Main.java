package com.yiqiang.repository.javase.thread.base.chapter06;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Title:
 * Description:
 *      Main class of the example. Creates three WriterTaks and a CleanerTask
 * Create Time: 2017/1/16 0016 3:41
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class Main {

    /**
     * Main method of the example. Creates three WriterTasks and a CleanerTask
     * @param args
     */
    public static void main(String[] args) {

        // Creates the Event data structure
        Deque<Event> deque=new ArrayDeque<Event>();

        // Creates the three WriterTask and starts them
        WriterTask writer=new WriterTask(deque);
        for (int i=0; i<3; i++){
            Thread thread=new Thread(writer);
            thread.start();
        }

        // Creates a cleaner task and starts them
        CleanerTask cleaner=new CleanerTask(deque);
        cleaner.start();

    }
}

/**
 * setDaemon()方法只能在start()方法被调用之前设置.一旦线程开始运行,将不能再修改守护状态.
 * isDaemon()方法被用来检查一个线程是不是守护线程(false：用户线程，true：守护线程)
 */
