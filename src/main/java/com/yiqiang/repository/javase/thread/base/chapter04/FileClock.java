package com.yiqiang.repository.javase.thread.base.chapter04;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Title:
 * Description:
 * Class that writes the actual date to a file every second
 * Create Time: 2017/1/16 0016 3:23
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class FileClock implements Runnable {

    /**
     * Main method of the class
     */
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s\n", new Date());
            try {
                // Sleep during one second
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.printf("The FileClock has been interrupted");
            }
        }
    }
}
