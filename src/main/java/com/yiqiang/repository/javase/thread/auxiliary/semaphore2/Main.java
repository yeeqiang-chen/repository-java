package com.yiqiang.repository.javase.thread.auxiliary.semaphore2;

/**
 * Title:
 * Description: Main class of the example.
 * Create Time: 2017/1/17 0017 22:59
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class Main {
    /**
     * Main method of the class. Run ten jobs in parallel that
     * send documents to the print queue at the same time.
     */
    public static void main (String args[]){

        // Creates the print queue
        PrintQueue printQueue=new PrintQueue();

        // Creates ten Threads
        Thread thread[]=new Thread[12];
        for (int i=0; i<12; i++){
            thread[i]=new Thread(new Job(printQueue),"Thread "+i);
        }

        // Starts the Threads
        for (int i=0; i<12; i++){
            thread[i].start();
        }
    }
}
