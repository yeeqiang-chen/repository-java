package com.yiqiang.repository.javase.thread.collection.delayqueue;

import java.util.Date;
import java.util.concurrent.DelayQueue;

/**
 * Title:
 * Description: This class implements a taks that store events in a delayed queue
 * Create Time: 2017/1/21 0021 16:06
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class Task implements Runnable {

    /**
     * Id of the task
     */
    private int id;

    /**
     * Delayed queue to store the events
     */
    private DelayQueue<Event> queue;

    /**
     * Constructor of the class. It initializes its attributes
     * @param id Id of the task
     * @param queue Delayed queue to store the events
     */
    public Task(int id, DelayQueue<Event> queue) {
        this.id=id;
        this.queue=queue;
    }


    /**
     * Main method of the task. It generates 100 events with the
     * same activation time. The activation time will be the execution
     * time of the thread plus the id of the thread seconds
     */
    @Override
    public void run() {

        Date now=new Date();
        Date delay=new Date();
        delay.setTime(now.getTime()+(id*1000));

        System.out.printf("Thread %s: %s\n",id,delay);

        for (int i=0; i<100; i++) {
            Event event=new Event(delay);
            queue.add(event);
        }
    }

}

