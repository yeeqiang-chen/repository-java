package com.yiqiang.repository.javase.thread.synchronization.chapter02_solution;

/**
 * Title:
 * Description: This class simulates a bank account
 * Create Time: 2017/1/16 0016 23:40
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class Account {

    /**
     * Balance of the bank account
     */
    private double balance;

    /**
     * Returns the balance of the account
     * @return the balance of the account
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Establish the balance of the account
     * @param balance the new balance of the account
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Add an import to the balance of the account
     * @param amount the import to add to the balance of the account
     */
    public synchronized void addAmount(double amount) {
        double tmp=balance;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tmp+=amount;
        balance=tmp;
    }

    /**
     * Subtract an import to the balance of the account
     * @param amount the import to subtract to the balance of the account
     */
    public synchronized void subtractAmount(double amount) {
        double tmp=balance;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tmp-=amount;
        balance=tmp;
    }
}
