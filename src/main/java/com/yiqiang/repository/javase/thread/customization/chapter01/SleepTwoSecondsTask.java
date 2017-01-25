package com.yiqiang.repository.javase.thread.customization.chapter01;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Title:
 * Description: Task implemented to test the customized executor
 * Create Time: 2017/1/21 0021 23:27
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class SleepTwoSecondsTask implements Callable<String> {

    /**
     * Main method of the tasks. It only sleeps the current thread for two seconds
     */
    public String call() throws Exception {
        TimeUnit.SECONDS.sleep(2);
        return new Date().toString();
    }

}
