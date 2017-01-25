package com.yiqiang.repository.javase.thread.auxiliary.exchanger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * Title:
 * Description: Main class of the example
 * Create Time: 2017/1/19 0019 1:42
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

        // Creates two buffers
        List<String> buffer1=new ArrayList<>();
        List<String> buffer2=new ArrayList<>();

        // Creates the exchanger
        Exchanger<List<String>> exchanger=new Exchanger<>();

        // Creates the producer
        Producer producer=new Producer(buffer1, exchanger);
        // Creates the consumer
        Consumer consumer=new Consumer(buffer2, exchanger);

        // Creates and starts the threads
        Thread threadProducer=new Thread(producer);
        Thread threadConsumer=new Thread(consumer);

        threadProducer.start();
        threadConsumer.start();

    }
}
