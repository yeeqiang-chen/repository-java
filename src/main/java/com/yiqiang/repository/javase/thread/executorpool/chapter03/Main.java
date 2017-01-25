package com.yiqiang.repository.javase.thread.executorpool.chapter03;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Title:
 * Description:
 * Main class of the example. Creates and execute ten FactorialCalculator tasks
 * in an executor controlling when they finish to write the results calculated
 * Create Time: 2017/1/19 0019 2:26
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class Main {
    /**
     * @param args
     */
    public static void main(String[] args) {

        // Create a ThreadPoolExecutor with fixed size. It has a maximun of two threads
        ThreadPoolExecutor executor=(ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        // List to store the Future objects that control the execution of  the task and
        // are used to obtain the results
        List<Future<Integer>> resultList=new ArrayList<>();

        // Create a random number generator
        Random random=new Random();
        // Create and send to the executor the ten tasks
        for (int i=0; i<10; i++){
            Integer number=new Integer(random.nextInt(10));
            FactorialCalculator calculator=new FactorialCalculator(number);
            Future<Integer> result=executor.submit(calculator);
            resultList.add(result);
        }

        // Wait for the finalization of the ten tasks
        do {
            System.out.printf("Main: Number of Completed Tasks: %d\n",executor.getCompletedTaskCount());
            for (int i=0; i<resultList.size(); i++) {
                Future<Integer> result=resultList.get(i);
                System.out.printf("Main: Task %d: %s\n",i,result.isDone());
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (executor.getCompletedTaskCount()<resultList.size());

        // Write the results
        System.out.printf("Main: Results\n");
        for (int i=0; i<resultList.size(); i++) {
            Future<Integer> result=resultList.get(i);
            Integer number=null;
            try {
                number=result.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.printf("Core: Task %d: %d\n",i,number);
        }

        // Shutdown the executor
        executor.shutdown();

    }
}

/**
 * 执行器框架的优势之一是,可以运行并发任务并返回结果
 *
 * Callable:这个接口声明了call()方法.可以在这个方法里实现任务的具体逻辑操作.
 *          Callable接口是一个泛型接口,这就意味着必须声明call()方法返回的数据类型
 *
 * Future:这个接口声明了一些方法来获取由Callable对象产生的结果,并管理他们的状态
 * Future对象可以用于以下两个主要目的：
 *  1.控制任务的状态:可以取消任务和检查任务是否已经完成.为了达到这个目的,可使用isDown()方法来检查任务是否已经完成
 *  2.通过call()方法获取返回的结果.为了达到这个目的,可使用get()方法.这个方法一直等待知道Callable
 *  对象的call()方法执行完成并返回结果.如果get()方法在等待结果时线程中断了,
 *  则将抛出一个InterruptedException异常。如果call()方法抛出异常那么get()方法
 *  随之抛出ExecutionException异常
 */