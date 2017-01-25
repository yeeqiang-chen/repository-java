package com.yiqiang.repository.javase.thread.synchronization.chapter04;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Title:
 * Description:
 *  This class implements an Event storage. Producers will storage
 * events in it and Consumers will process them. An event will
 * be a java.util.Date object
 * Create Time: 2017/1/17 0017 0:13
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class EventStorage {

    /**
     * Maximum size of the storage
     */
    private int maxSize;
    /**
     * Storage of events
     */
    private List<Date> storage;

    /**
     * Constructor of the class. Initializes the attributes.
     */
    public EventStorage(){
        maxSize=10;
        storage=new LinkedList<>();
    }

    /**
     * This method creates and storage an event.
     */
    public synchronized void set(){
        while (storage.size()==maxSize){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        storage.add(new Date());
        System.out.printf("Set: %d",storage.size());
        notify();
    }

    /**
     * This method delete the first event of the storage.
     */
    public synchronized void get(){
        while (storage.size()==0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("Get: %d: %s",storage.size(),((LinkedList<?>)storage).poll());
        notify();
    }
}
