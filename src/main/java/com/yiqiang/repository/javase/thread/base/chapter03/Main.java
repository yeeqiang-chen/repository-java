package com.yiqiang.repository.javase.thread.base.chapter03;

import java.util.concurrent.TimeUnit;

/**
 * Title:
 * Description:
 *  Main class of the example. Search for the autoexect.bat file
 *  on the Windows root folder and its subfolders during ten seconds
 *  and then, interrupts the Thread
 * Create Time: 2017/1/16 0016 3:15
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class Main {
    /**
     * Main method of the core. Search for the autoexect.bat file
     * on the Windows root folder and its subfolders during ten seconds
     * and then, interrupts the Thread
     * @param args
     */
    public static void main(String[] args) {
        // Creates the Runnable object and the Thread to run it
        FileSearch searcher=new FileSearch("D:\\","autoexec.bat");
        Thread thread=new Thread(searcher);

        // Starts the Thread
        thread.start();

        // Wait for ten seconds
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Interrupts the thread
        thread.interrupt();
    }
}
