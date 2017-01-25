package com.yiqiang.repository.javase.thread.collection.priorityblockingqueue;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Title:
 * Description:
 * This class implements a generator of events. It generates
 * 1000 events and stores them in a priory queue
 * Create Time: 2017/1/21 0021 15:52
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
     * Priority queue to store the events
     */
    private PriorityBlockingQueue<Event> queue;

    /**
     * Constructor of the class. It initializes its attributes
     * @param id Id of the task
     * @param queue Priority queue to store the events
     */
    public Task(int id, PriorityBlockingQueue<Event> queue) {
        this.id=id;
        this.queue=queue;
    }

    /**
     * Main method of the task. It generates 1000 events and store
     * them in the queue
     */
    @Override
    public void run() {
        for (int i=0; i<1000; i++){
            Event event=new Event(id,i);
            queue.add(event);
        }
    }
}