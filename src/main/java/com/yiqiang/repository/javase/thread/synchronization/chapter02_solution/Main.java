package com.yiqiang.repository.javase.thread.synchronization.chapter02_solution;

/**
 * Title:
 * Description:
 * Create Time: 2017/1/16 0016 23:34
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
        Company	company=new Company(account);
        Thread companyThread=new Thread(company);
        // Creates a new Bank and a Thread to run its task
        Bank bank=new Bank(account);
        Thread bankThread=new Thread(bank);

        // Prints the initial balance
        System.out.printf("Account : Initial Balance: %f\n",account.getBalance());

        // Starts the Threads
        companyThread.start();
        bankThread.start();

        try {
            // Wait for the finalization of the Threads
            companyThread.join();
            bankThread.join();
            // Print the final balance
            System.out.printf("Account : Final Balance: %f\n",account.getBalance());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 如果一个对象已用synchronized关键字声明,那么只有一个执行线程被允许访问它
 * 如果其他某个线程试图访问这个对象的其他方法,它将被挂起直到第一个线程执行完正在运行的方法
 *
 * 用synchronized关键字声明的静态方法,同时只能够被一个执行线程访问,但是其他线程可以访问这个对象
 * 的非静态方法.必须非常谨慎这一点,因为两个线程可以同时访问一个对象的两个不容
 * 的synchroniced方法,即其中一个静态方法,另一个是非静态方法.如果两个方法都改变了相同的数据,
 * 将会出现数据不一致的错误
 *
 * 可以递归调用被synchronized声明的方法.当线程访问一个对象的同步方法时,
 * 它还可以调用这个对象的其他的同步方法,也包含正在执行的方法,而不必再次去获取
 * 这个方法的访问权
 *
 * 同步代码块
 * synchronized (this) {
 *     // java code
 * }
 */