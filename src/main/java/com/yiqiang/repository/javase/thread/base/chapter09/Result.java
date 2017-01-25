package com.yiqiang.repository.javase.thread.base.chapter09;

/**
 * Title:
 * Description: Class that stores the result of the search
 * Create Time: 2017/1/16 0016 22:24
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class Result {

    /**
     * Name of the Thread that finish
     */
    private String name;

    /**
     * Read the name of the Thread
     * @return The name of the Thread
     */
    public String getName() {
        return name;
    }

    /**
     * Write the name of the Thread
     * @param name The name of the Thread
     */
    public void setName(String name) {
        this.name = name;
    }
}
