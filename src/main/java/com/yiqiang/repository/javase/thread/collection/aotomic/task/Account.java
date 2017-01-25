package com.yiqiang.repository.javase.thread.collection.aotomic.task;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Title:
 * Description: This class simulate a bank account
 * Create Time: 2017/1/21 0021 16:34
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class Account {
    /**
     * Balance of the bank account
     */
    private AtomicLong balance;

    public Account(){
        balance=new AtomicLong();
    }

    /**
     * Returns the balance of the account
     * @return the balance of the account
     */
    public long getBalance() {
        return balance.get();
    }

    /**
     * Establish the balance of the account
     * @param balance the new balance of the account
     */
    public void setBalance(long balance) {
        this.balance.set(balance);
    }

    /**
     * Add an import to the balance of the account
     * @param amount import to add to the balance
     */
    public void addAmount(long amount) {
        this.balance.getAndAdd(amount);
    }

    /**
     * Subtract an import to the balance of the account
     * @param amount import to subtract to the balance
     */
    public void subtractAmount(long amount) {
        this.balance.getAndAdd(-amount);
    }
}
