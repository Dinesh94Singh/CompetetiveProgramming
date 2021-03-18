package com.company.codingscales.leetcode.concepts.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// lock and unlock for reentrant lock
public class DesignBlockingQueueWithReentrantLock {
    static class BlockingQueueWithMutex<T> {
        T[] array;
        Lock lock = new ReentrantLock();
        int size = 0;
        int capacity;
        int head = 0;
        int tail = 0;

        @SuppressWarnings("unchecked")
        public BlockingQueueWithMutex(int capacity) {
            // The casting results in a warning
            array = (T[]) new Object[capacity];
            this.capacity = capacity;
        }

        public T dequeue() throws InterruptedException {
            T item = null;

            lock.lock();
            while (size == 0) {
                lock.unlock(); // TODO: use conditions instead
                lock.lock();
            }

            if (head == capacity) {
                head = 0;
            }

            item = array[head];
            array[head] = null;
            head++;
            size--;

            lock.unlock();
            return item;
        }

        public void enqueue(T item) throws InterruptedException {
            lock.lock();
            while (size == capacity) {
                // Release the mutex to give other threads
                lock.unlock();
                // Reacquire the mutex before checking the
                // condition
                lock.lock();
            }

            if (tail == capacity) {
                tail = 0;
            }

            array[tail] = item;
            size++;
            tail++;
            lock.unlock();
        }
    }

    // Main
    static BlockingQueueWithMutex<Integer> q = new BlockingQueueWithMutex<>(5);
    static void producerThread(int start, int id ) {
        while (true) {
            try {
                q.enqueue(start);
                System.out.println("Producer thread " + id + " enqueued " + start);
                start++;
                Thread.sleep(1);
            } catch (InterruptedException ie){
                // swallow exception
            }
        }
    }

    static void consumerThread(int id) {
        while (true) {
            try {
                System.out.println("Consumer thread " + id + " dequeued " + q.dequeue());
                Thread.sleep(1);
            } catch (InterruptedException ie){
                // swallow exception
            }
        }
    }

    public static void main( String args[] ) throws InterruptedException {

        Thread producer1 = new Thread(new Runnable() {
            public void run() {
                producerThread(1, 1);
            }
        });

        Thread producer2 = new Thread(new Runnable() {
            public void run() {
                producerThread(5000, 2);
            }
        });

        Thread producer3 = new Thread(new Runnable() {
            public void run() {
                producerThread(100000, 3);
            }
        });

        Thread consumer1 = new Thread(new Runnable() {
            public void run() {
                consumerThread(1);
            }
        });

        Thread consumer2 = new Thread(new Runnable() {
            public void run() {
                consumerThread(2);
            }
        });

        Thread consumer3 = new Thread(new Runnable() {
            public void run() {
                consumerThread(3);
            }
        });

        producer1.setDaemon(true);
        producer2.setDaemon(true);
        producer3.setDaemon(true);
        consumer1.setDaemon(true);
        consumer2.setDaemon(true);
        consumer3.setDaemon(true);

        producer1.start();
        producer2.start();
        producer3.start();

        consumer1.start();
        consumer2.start();
        consumer3.start();

        Thread.sleep(20000);
    }
}
