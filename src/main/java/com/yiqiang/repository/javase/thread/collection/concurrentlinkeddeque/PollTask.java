package com.yiqiang.repository.javase.thread.collection.concurrentlinkeddeque;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Title:
 * Description: Task that delete 10000 elements from a ConcurrentListDeque
 * Create Time: 2017/1/21 0021 15:28
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class PollTask implements Runnable {

    /**
     * List to delete the elements
     */
    private ConcurrentLinkedDeque<String> list;

    /**
     * Constructor of the class
     *
     * @param list List to delete the elements
     */
    public PollTask(ConcurrentLinkedDeque<String> list) {
        this.list = list;
    }

    /**
     * Main method of the task. Deletes 10000 elements from the
     * list using the pollFirst() that deletes the first element of the
     * list and pollLast() that deletes the last element of the list
     */
    @Override
    public void run() {
        for (int i = 0; i < 5000; i++) {
            list.pollFirst();
            list.pollLast();
        }
    }
}