package com.company.codingscales.leetcode.concepts.design;

import java.util.concurrent.locks.ReentrantLock;

public class CircularQueueThreadSafe {
    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            next = null;
        }
    }

    private Node tail;
    private int count;
    private final int capacity;
    // Additional variable to secure the access of our queue
    private final ReentrantLock queueLock = new ReentrantLock();

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public CircularQueueThreadSafe(int k) {
        this.capacity = k;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        // ensure the exclusive access for the following block.
        queueLock.lock();
        try {
            if (this.count == this.capacity)
                return false;

            Node newNode = new Node(value);
            if (this.count == 0) {
                Node head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            this.count += 1;
        } finally {
            queueLock.unlock();
        }
        return true;
    }
}
