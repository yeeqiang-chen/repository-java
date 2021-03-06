package com.yiqiang.repository.javase.thread.collection.aotomic.task;

/**
 * Title:
 * Description: This class simulates a company that pays a salary an insert money into an account
 * Create Time: 2017/1/21 0021 16:35
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class Company implements Runnable {

    /**
     * The account affected by the operations
     */
    private Account account;

    /**
     * Constructor of the class. Initializes the account
     * @param account the account affected by the operations
     */
    public Company(Account account) {
        this.account=account;
    }

    /**
     * Core method of the Runnable
     */
    @Override
    public void run() {
        for (int i=0; i<10; i++){
            account.addAmount(1000);
        }
    }

}

