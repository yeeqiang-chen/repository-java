package com.yiqiang.repository.javase.thread.auxiliary.semaphore1;

/**
 * Title:
 * Description: Main class of the example.
 * Create Time: 2017/1/17 0017 1:47
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
        Thread thread[]=new Thread[10];
        for (int i=0; i<10; i++){
            thread[i]=new Thread(new Job(printQueue),"Thread "+i);
        }

        // Starts the Threads
        for (int i=0; i<10; i++){
            thread[i].start();
        }
    }
}

/**
 * 信号量是一种计数器,用来保护一个或者多个共享资源的访问
 *
 * 如果线程要访问一个共享资源,它必须先获得信号量.如果信号量的内部计数器大于0,信号量将减1,
 * 然后允许访问这个共享资源.计数器大于0意味着有可以使用的资源,因此线程将被允许使用其中一个资源
 *
 * 否则,如果信号量的计数器等于0,信号量将会把线程置入休眠直至计数器大于0.
 * 计数器等于0的时候意味着所有的共享资源已经被其他线程使用了,所有需要访问这个共享资源的线程必须等待
 *
 * 当线程使用完某个共享资源时,信号量必须被释放,以便其他线程能够访问共享资源.
 * 释放操作将使信号量的内部计数器增加1
 *
 * 通过调用acquire()方法获得信号量,它会抛出InterruptedException
 * 通过调用release()方法释放信号量
 *
 * acquireUninterruptibly()
 *
 * tryAcquire()
 *
 * 信号量的公平性
 */