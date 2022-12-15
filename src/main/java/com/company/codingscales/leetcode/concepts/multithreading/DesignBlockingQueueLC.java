package com.company.codingscales.leetcode.concepts.multithreading;

import java.util.*;

public class DesignBlockingQueueLC {

    ArrayDeque<Integer> dq;
    int size;

    Object lock = new Object();

    public DesignBlockingQueueLC(int capacity) {
        dq = new ArrayDeque<>();
        size = capacity;
    }

    public void enqueue(int element) throws InterruptedException {
        synchronized (lock) {
            while (dq.size() == size) {
                lock.wait();
            }

            dq.offerLast(element);
            lock.notifyAll();
        }
    }

    public int dequeue() throws InterruptedException {
        synchronized (lock) {
            while (dq.size() == 0) {
                lock.wait();
            }

            int element = dq.pollFirst();
            lock.notifyAll();

            return element;
        }
    }

    public int size() {
        return dq.size();
    }
}
