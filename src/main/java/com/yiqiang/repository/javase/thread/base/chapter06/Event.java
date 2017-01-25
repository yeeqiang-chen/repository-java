package com.yiqiang.repository.javase.thread.base.chapter06;

import java.util.Date;

/**
 * Title:
 * Description:
 *     Class that stores event's information
 * Create Time: 2017/1/16 0016 3:39
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class Event {

    /**
     * Date of the event
     */
    private Date date;

    /**
     * Message of the event
     */
    private String event;

    /**
     * Reads the Date of the event
     * @return the Date of the event
     */
    public Date getDate() {
        return date;
    }

    /**
     * Writes the Date of the event
     * @param date the date of the event
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Reads the message of the event
     * @return the message of the event
     */
    public String getEvent() {
        return event;
    }

    /**
     * Writes the message of the event
     * @param event the message of the event
     */
    public void setEvent(String event) {
        this.event = event;
    }
}
