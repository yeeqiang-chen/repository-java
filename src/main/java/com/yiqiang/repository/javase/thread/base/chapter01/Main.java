package com.yiqiang.repository.javase.thread.base.chapter01;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Title:
 * Description:
 * ID: 保存了线程的唯一表示符
 * Name: 保存了线程名称
 * Priority: 保存了线程对象的优先级.线程的优先级是从1到10,其中1是最低优先级;10是最高优先级
 * @link Thread#State Thread.State
 * Status: 保存了线程的状态.在Java中,线程的状态有6中:NEW,RUNNABLE,BLOCKED,WAITING,TIMED_WAITING,TERMINATED
 * Create Time: 2017/1/16 0016 0:34
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        /*for (int i = 1; i <= 10 ; i++) {
            Calculator calculator = new Calculator(i);
            Thread thread = new Thread(calculator);
            thread.start();
        }*/

        // Thread priority infomation
        System.out.printf("Minimum Priority: %s\n",Thread.MIN_PRIORITY);
        System.out.printf("Normal Priority: %s\n",Thread.NORM_PRIORITY);
        System.out.printf("Maximun Priority: %s\n",Thread.MAX_PRIORITY);

        // Launch 10 threads to do the operation, 5 with the max
        // priority, 5 with the min
        Thread [] threads = new Thread[10];
        Thread.State [] status = new Thread.State[10];
        for (int i = 0; i <10 ; i++) {
            threads[i] = new Thread(new Calculator(i));
            if ((i % 2) == 0) {
                threads[i].setPriority(Thread.MAX_PRIORITY);
            } else {
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            threads[i].setName("Thread " + i);
        }
        // Wait for the finalization of the threads. Meanwhile,
        // write the status of those threads in a file
        try (FileWriter file = new FileWriter(".\\data\\log.txt"); PrintWriter pw = new PrintWriter(file);) {
            for (int i = 0; i < 10; i++) {
                pw.println("Main :  Status of Thread " + i + " : " + threads[i].getState());
                status[i] = threads[i].getState();
            }
            for (int i = 0; i < 10; i++) {
                threads[i].start();
            }
            boolean finish = false;
            while (!finish) {
                for (int i = 0; i < 10; i++) {
                    if (threads[i].getState() != status[i]) {
                        writeThreadInfo(pw, threads[i], status[i]);
                        status[i] = threads[i].getState();
                    }
                }
                finish = true;
                for (int i = 0; i < 10; i++) {
                    finish = finish && (threads[i].getState() == Thread.State.TERMINATED);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method writes the state of a thread in a file
     * @param pw : PrintWriter to write the data
     * @param thread : Thread whose information will be written
     * @param state : Old state of the thread
     */
    private static void writeThreadInfo(PrintWriter pw, Thread thread, Thread.State state) {
        pw.printf("Main : Id %d - %s\n",thread.getId(), thread.getName());
        pw.printf("Main : Priority %d\n",thread.getPriority());
        pw.printf("Main : Old State %s\n", state);
        pw.printf("Main : New State %s\n",thread.getState());
        pw.printf("Main : *********************************************\n");
    }
}