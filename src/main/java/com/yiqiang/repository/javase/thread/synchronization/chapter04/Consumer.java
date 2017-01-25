package com.yiqiang.repository.javase.thread.synchronization.chapter04;

/**
 * Title:
 * Description: This class implements a consumer of events.
 * Create Time: 2017/1/17 0017 0:14
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class Consumer implements Runnable {

    /**
     * Store to work with
     */
    private EventStorage storage;

    /**
     * Constructor of the class. Initialize the storage
     * @param storage The store to work with
     */
    public Consumer(EventStorage storage){
        this.storage=storage;
    }

    /**
     * Core method for the consumer. Consume 100 events
     */
    @Override
    public void run() {
        for (int i=0; i<100; i++){
            storage.get();
        }
    }

}
