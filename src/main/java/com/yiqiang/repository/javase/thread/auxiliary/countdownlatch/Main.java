package com.yiqiang.repository.javase.thread.auxiliary.countdownlatch;

/**
 * Title:
 * Description: Main class of the example. Create, initialize and execute all the objects necessaries for the example
 * Create Time: 2017/1/18 0018 22:44
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

        // Creates a VideoConference with 10 participants.
        Videoconference conference=new Videoconference(10);
        // Creates a thread to run the VideoConference and start it.
        Thread threadConference=new Thread(conference);
        threadConference.start();

        // Creates ten participants, a thread for each one and starts them
        for (int i=0; i<10; i++){
            Participant p=new Participant(conference, "Participant "+i);
            Thread t=new Thread(p);
            t.start();
        }

    }
}

/**
 * CountDownLatch类有三个基本元素：
 * 一个初始值,即定义必须等待的先行完成的操作的数据；
 * await()方法,需要等待其他事件先完成的线程调用；
 * countDown()方法,每个被等待的事件在完成的时候调用；
 *
 * 当创建CountDownLatch对象时,使用构造器来初试内部计数器.
 * 当countDown()方法被调用后,计数器将减1.当计数器到达0的时候,CountDownLatch对象
 * 将唤起所有在await()方法上等待的线程
 *
 * CountDownLatch对象的内部计数器被初始化之后就不能在此初始化或者修改.
 * 一旦计数器被初始化后,唯一能改变参数值的方法是countDown()方法.
 * 当计数器到达0时,所有因调用await()方法而等待的线程立刻被唤醒,再执行countD()将不起任何作用
 *
 * 和其他同步方法相比,CountDownLatch机制有下述不同:
 * CountDownLatch机制不是用来保护共享资源或者临界区的,它是用来同步执行多个任务的一个或者多个线程;
 * CountDownLatch只准许进入一次.如同解释的,一旦CountDownLatch的内部计数器到达0,
 * 再调用这个方法将不起作用,如果要做类似的同步,就必须创建一个新的CountDownLatch对象
 */