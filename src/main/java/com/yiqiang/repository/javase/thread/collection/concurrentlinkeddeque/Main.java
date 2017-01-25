package com.yiqiang.repository.javase.thread.collection.concurrentlinkeddeque;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Title:
 * Description:
 * Main class of the example. First, execute 100 AddTask objects to
 * add 1000000 elements to the list and the execute 100 PollTask objects
 * to delete all those elements.
 * Create Time: 2017/1/21 0021 15:28
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class Main {
    /**
     * Main method of the class
     * @param args
     */
    public static void main(String[] args) throws Exception {

        // Create a ConcurrentLinkedDeque to work with it in the example
        ConcurrentLinkedDeque<String> list=new ConcurrentLinkedDeque<>();
        // Create an Array of 100 threads
        Thread threads[]=new Thread[100];

        // Create 100 AddTask objects and execute them as threads
        for (int i=0; i<threads.length; i++){
            AddTask task=new AddTask(list);
            threads[i]=new Thread(task);
            threads[i].start();
        }
        System.out.printf("Main: %d AddTask threads have been launched\n",threads.length);

        // Wait for the finalization of the threads
        for (int i=0; i<threads.length; i++) {
            threads[i].join();
        }

        // Write to the console the size of the list
        System.out.printf("Main: Size of the List: %d\n",list.size());

        // Create 100 PollTask objects and execute them as threads
        for (int i=0; i<threads.length; i++){
            PollTask task=new PollTask(list);
            threads[i]=new Thread(task);
            threads[i].start();
        }
        System.out.printf("Main: %d PollTask threads have been launched\n",threads.length);

        // Wait for the finalization of the threads
        for (int i=0; i<threads.length; i++) {
            threads[i].join();
        }

        // Write to the console the size of the list
        System.out.printf("Main: Size of the List: %d\n",list.size());
    }
}

/**
 * 阻塞式集合(Blocking Collection):这类集合包括添加和移除数据的方法.
 * 当集合已满或为空时,被调用的添加或者移除方法就不能立即执行,那么调用这个方法的线程将
 * 被阻塞,一直到该方法可以被成功执行.
 *
 * 非阻塞式集合(Non-Blocking Collection):这类集合也包括添加和移除数据的方法.
 * 如果方法不能立即执行,则返回null或者抛出异常,但是调用这个方法的线程不会被阻塞
 *
 *
 * ConcuttentLinkedDeque:非阻塞式线程安全列表
 *
 * LinkedBlocingDeque:阻塞式列表
 *
 * LinkedTransferQueue:用于数据生成或消费的阻塞式列表
 *
 * PriorityBlockingQueue:按优先级排序列表元素的阻塞式列表
 *
 * DelayQueue:带有延迟列表元素的阻塞式列表
 *
 * ConcurrentSkipListMap:非阻塞时可遍历映射的实现类
 *
 * ThreadLocalRandom:随机数字对应的实现类
 *
 * AtomicLong,AtomicIntegerArray:原子变量对应的实现类
 */
