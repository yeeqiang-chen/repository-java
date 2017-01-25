package com.yiqiang.repository.javase.thread.collection.delayqueue;

import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * Title:
 * Description:
 * Main method of the example. Execute five tasks and then
 * take the events of the delayed queue when they are activated
 * Create Time: 2017/1/21 0021 16:06
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class Main {
    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {

		/*
		 * Delayed queue to store the events
		 */
        DelayQueue<Event> queue=new DelayQueue<>();

		/*
		 * An array to store the Thread objects that execute the tasks
		 */
        Thread threads[]=new Thread[5];

		/*
		 * Create the five tasks
		 */
        for (int i=0; i<threads.length; i++){
            Task task=new Task(i+1, queue);
            threads[i]=new Thread(task);
        }

		/*
		 * Execute the five tasks
		 */
        for (int i=0; i<threads.length; i++) {
            threads[i].start();
        }

		/*
		 * Wait for the finalization of the five tasks
		 */
        for (int i=0; i<threads.length; i++) {
            threads[i].join();
        }

		/*
		 * Write the results to the console
		 */
        do {
            int counter=0;
            Event event;
            do {
                event=queue.poll();
                if (event!=null) counter++;
            } while (event!=null);
            System.out.printf("At %s you have read %d events\n",new Date(),counter);
            TimeUnit.MILLISECONDS.sleep(500);
        } while (queue.size()>0);
    }

}

/**
 * DelayQueue,这个类可以存放带有激活日期的元素.当调用方法从队列中返回或提取
 * 数据时,未来的元素日期将被忽略.这些元素对于这些方法是不可见的
 *
 * 为了具有调用行为,存放到DelayQueue类中的元素必须继承Delayed接口.
 * Delayed接口使对象成为延迟对象,它使存放在DelayedQueue类中的对象具有了
 * 激活日期,即到激活日期的时间.该接口强制执行下列两个方法:
 * compareTo(Delayed o)
 * getDelay(TimeUnit unit)
 */
