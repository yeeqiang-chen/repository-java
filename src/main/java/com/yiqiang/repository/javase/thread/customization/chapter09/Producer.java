package com.yiqiang.repository.javase.thread.customization.chapter09;

/**
 * Title:
 * Description:
 * This class implements the producers of data. It store 100
 * events in the queue with incremental priority
 * Create Time: 2017/1/23 0023 2:38
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class Producer implements Runnable {

    /**
     * Buffer used to store the events
     */
    private MyPriorityTransferQueue<Event> buffer;

    /**
     * Constructor of the class. It initializes its parameters
     * @param buffer Buffer to store the events
     */
    public Producer(MyPriorityTransferQueue<Event> buffer) {
        this.buffer=buffer;
    }

    /**
     * Main method of the producer. Store 100 events in the buffer with
     * incremental priority
     */
    @Override
    public void run() {
        for (int i=0; i<100; i++) {
            Event event=new Event(Thread.currentThread().getName(),i);
            buffer.put(event);
        }
    }

}
