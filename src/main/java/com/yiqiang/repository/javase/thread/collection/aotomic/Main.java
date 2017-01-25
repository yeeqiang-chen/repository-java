package com.yiqiang.repository.javase.thread.collection.aotomic;

import com.yiqiang.repository.javase.thread.collection.aotomic.task.Account;
import com.yiqiang.repository.javase.thread.collection.aotomic.task.Bank;
import com.yiqiang.repository.javase.thread.collection.aotomic.task.Company;

/**
 * Title:
 * Description:
 * Main class of the example. It creates an account, a company and a bank
 * to work with the account. The final balance should be equal to the initial, but....
 * Create Time: 2017/1/21 0021 16:34
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class Main {
    /**
     * Main method of the example
     * @param args
     */
    public static void main(String[] args) {
        // Creates a new account ...
        Account account=new Account();
        // an initialize its balance to 1000
        account.setBalance(1000);

        // Creates a new Company and a Thread to run its task
        Company company=new Company(account);
        Thread companyThread=new Thread(company);
        // Creates a new Bank and a Thread to run its task
        Bank bank=new Bank(account);
        Thread bankThread=new Thread(bank);

        // Prints the initial balance
        System.out.printf("Account : Initial Balance: %d\n",account.getBalance());

        // Starts the Threads
        companyThread.start();
        bankThread.start();

        try {
            // Wait for the finalization of the Threads
            companyThread.join();
            bankThread.join();
            // Print the final balance
            System.out.printf("Account : Final Balance: %d\n",account.getBalance());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
