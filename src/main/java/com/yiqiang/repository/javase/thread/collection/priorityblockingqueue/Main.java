package com.yiqiang.repository.javase.thread.collection.priorityblockingqueue;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Title:
 * Description:
 * Main class of the example. Executes five threads that
 * store their events in a common priority queue and writes
 * them in the console to verify the correct operation of the
 * PriorityBlockingQueue class
 * Create Time: 2017/1/21 0021 15:53
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class Main {
    /**
     * @param args
     */
    public static void main(String[] args) {
		/*
		 * Priority queue to store the events
		 */
        PriorityBlockingQueue<Event> queue=new PriorityBlockingQueue<>();

		/*
		 * An array to store the five Thread objects
		 */
        Thread taskThreads[]=new Thread[5];

		/*
		 * Create the five threads to execute five tasks
		 */
        for (int i=0; i<taskThreads.length; i++){
            Task task=new Task(i,queue);
            taskThreads[i]=new Thread(task);
        }

		/*
		 * Start the five threads
		 */
        for (int i=0; i<taskThreads.length; i++) {
            taskThreads[i].start();
        }

		/*
		 * Wait for the finalization of the five threads
		 */
        for (int i=0; i<taskThreads.length; i++) {
            try {
                taskThreads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

		/*
		 * Write the events in the console
		 */
        System.out.printf("Main: Queue Size: %d\n",queue.size());
        for (int i=0; i<taskThreads.length*1000; i++){
            Event event=queue.poll();
            System.out.printf("Thread %s: Priority %d\n",event.getThread(),event.getPriority());
        }
        System.out.printf("Main: Queue Size: %d\n",queue.size());
        System.out.printf("Main: End of the program\n");
    }
}

/**
 * 所有添加进PriorityBlockingQueue的元素必须实现Comparable接口,这个接口提供了
 * compareTo()方法,它的传入参数是一个同类型的对象
 * 如果当前对象小于参数传入的对象,那么返回一个小于0的值;
 * 如果当前对象大于参数传入的对象,那么返回一个大于0的值;
 * 如果当前对象等于参数传入的对象,那么返回一个等于0的值;
 *
 * ProrityBlockingQueue的另一个重要的特性是:它是阻塞式数据结构.
 * 当它的方法被调用并且不能立即执行时,调用这个方法的线程将被阻塞直到方法执行成功
 */
