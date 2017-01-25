package com.yiqiang.repository.javase.thread.synchronization.chapter04;

/**
 * Title:
 * Description: This class implements a producer of events.
 * Create Time: 2017/1/17 0017 0:12
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class Producer implements Runnable {

    /**
     * Store to work with
     */
    private EventStorage storage;

    /**
     * Constructor of the class. Initialize the storage.
     * @param storage The store to work with
     */
    public Producer(EventStorage storage){
        this.storage=storage;
    }

    /**
     * Core method of the producer. Generates 100 events.
     */
    @Override
    public void run() {
        for (int i=0; i<100; i++){
            storage.set();
        }
    }
}
