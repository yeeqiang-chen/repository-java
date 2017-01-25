package com.yiqiang.repository.javase.thread.collection.priorityblockingqueue;

/**
 * Title:
 * Description:
 * This class stores the attributes of an event. Its thread
 * and is priority. Implements the comparable interface to
 * help the priority queue to decide which event has more priority
 * Create Time: 2017/1/21 0021 15:52
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class Event implements Comparable<Event> {

    /**
     * Number of the thread that generates the event
     */
    private int thread;
    /**
     * Priority of the thread
     */
    private int priority;

    /**
     * Constructor of the thread. It initializes its attributes
     * @param thread Number of the thread that generates the event
     * @param priority Priority of the event
     */
    public Event(int thread, int priority){
        this.thread=thread;
        this.priority=priority;
    }

    /**
     * Method that returns the number of the thread that generates the
     * event
     * @return The number of the thread that generates the event
     */
    public int getThread() {
        return thread;
    }

    /**
     * Method that returns the priority of the event
     * @return The priority of the event
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Method that compares two events and decide which has more priority
     */
    @Override
    public int compareTo(Event e) {
        if (this.priority>e.getPriority()) {
            return -1;
        } else if (this.priority<e.getPriority()) {
            return 1;
        } else {
            return 0;
        }
    }
}
