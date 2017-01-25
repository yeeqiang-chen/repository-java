package com.yiqiang.repository.javase.thread.base.chapter01;

/**
 * Title:
 * Description:
 * Create Time: 2017/1/16 0016 0:32
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class Calculator implements Runnable{
    private int number;

    public Calculator(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10 ; i++) {
            System.out.printf("%s: %d * %d = %d\n", Thread.currentThread().getName(), number, i, i * number);
        }
    }
}
