package com.yiqiang.repository.javase.thread.executorpool.chapter01;

/**
 * Title:
 * Description: Main class of the example. Creates a server and 100 request of the Task class
 * that sends to the server
 * Create Time: 2017/1/19 0019 2:07
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
        // Create the server
        Server server=new Server();

        // Send 100 request to the server and finish
        for (int i=0; i<100; i++){
            Task task=new Task("Task "+i);
            server.executeTask(task);
        }

        server.endServer();

    }
}
