package com.yiqiang.repository.javase.thread.synchronization.chapter06;

/**
 * Title:
 * Description: This class implements a writer that establish the prices
 * Create Time: 2017/1/17 0017 0:39
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class Writer implements Runnable {

    /**
     * Class that stores the prices
     */
    private PricesInfo pricesInfo;

    /**
     * Constructor of the class
     * @param pricesInfo object that stores the prices
     */
    public Writer(PricesInfo pricesInfo){
        this.pricesInfo=pricesInfo;
    }

    /**
     * Core method of the writer. Establish the prices
     */
    @Override
    public void run() {
        for (int i=0; i<3; i++) {
            System.out.printf("Writer: Attempt to modify the prices.\n");
            pricesInfo.setPrices(Math.random()*10, Math.random()*8);
            System.out.printf("Writer: Prices have been modified.\n");
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
