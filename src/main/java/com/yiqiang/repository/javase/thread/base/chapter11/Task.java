package com.yiqiang.repository.javase.thread.base.chapter11;

import java.util.concurrent.TimeUnit;

/**
 * Title:
 * Description:
 * Create Time: 2017/1/16 0016 23:19
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class Task implements Runnable {

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

