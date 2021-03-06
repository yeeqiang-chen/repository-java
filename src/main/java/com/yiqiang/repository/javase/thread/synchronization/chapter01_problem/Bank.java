package com.yiqiang.repository.javase.thread.synchronization.chapter01_problem;

/**
 * Title:
 * Description: This class simulates a bank or a cash dispenser that takes money
 *      from an account
 * Create Time: 2017/1/16 0016 23:33
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class Bank implements Runnable{

    /**
     * The account affected by the operations
     */
    private Account account;

    /**
     * Constructor of the class. Initializes the account
     * @param account The account affected by the operations
     */
    public Bank(Account account) {
        this.account=account;
    }


    /**
     * Core method of the Runnable
     */
    public void run() {
        for (int i=0; i<100; i++){
            account.subtractAmount(1000);
        }
    }
}
