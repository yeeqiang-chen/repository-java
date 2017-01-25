package com.yiqiang.repository.javase.thread.customization.chapter08;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * Title:
 * Description:
 * This class extends the AbstractQueueSynchronizer class to implement
 * the basis of a Lock. Internally, it uses an AtomicInteger variable
 * to store the state of the lock. It also stores the current thread that
 * has the lock. The tryAcquire()  method and tryRelease() method
 * are the starting point for the Lock implementation
 * Create Time: 2017/1/22 0022 23:35
 *
 * @author: YEEQiang
 * @version: 1.0
 */
public class MyAbstractQueuedSynchronizer extends AbstractQueuedSynchronizer {

    /**
     * Serial version UID of the class
     */
    private static final long serialVersionUID = 1L;

    /**
     * Attribute that stores the state of the lock. 0 if it's free, 1 if it's busy
     */
    private AtomicInteger state;

    /**
     * Constructor of the class
     */
    public MyAbstractQueuedSynchronizer() {
        state=new AtomicInteger(0);
    }

    /**
     * This method try to acquire the control of the lock
     * @return true if the thread acquires the lock, false otherwise
     */
    @Override
    protected boolean tryAcquire(int arg) {
        return state.compareAndSet(0, 1);
    }

    /**
     * This method try to free the control of the lock
     * @return true if the thread releases the lock, false otherwise
     */
    @Override
    protected boolean tryRelease(int arg) {
        return state.compareAndSet(1, 0);
    }
}
