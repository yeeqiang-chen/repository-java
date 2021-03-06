package com.yiqiang.repository.javase.thread.synchronization.chapter09;

/**
 * Title:
 * Description: This class simulates a sensor in the building
 * Create Time: 2017/1/17 0017 1:36
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class Sensor1 implements Runnable {

    /**
     * Object with the statistics of the building
     */
    private BuildStats stats;

    /**
     * Constructor of the class
     * @param stats object with the statistics of the building
     */
    public Sensor1(BuildStats stats){
        this.stats=stats;
    }

    /**
     * Core method of the Runnable. Simulates inputs and outputs in the building
     */
    @Override
    public void run() {
        stats.comeIn();
        stats.comeIn();
        stats.comeIn();
        stats.goOut();
        stats.comeIn();
    }

}
