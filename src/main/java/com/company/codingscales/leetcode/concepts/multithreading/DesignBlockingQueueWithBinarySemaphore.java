package com.company.codingscales.leetcode.concepts.multithreading;

public class DesignBlockingQueueWithBinarySemaphore {
    static class BlockingQueueWithSemaphore<T> {
        T[] array;
        int size = 0;
        int capacity;
        int head = 0;
        int tail = 0;
        CountingSemaphore semLock = new CountingSemaphore(1, 1);
        CountingSemaphore semProducer;
        CountingSemaphore semConsumer;

        @SuppressWarnings("unchecked")
        public BlockingQueueWithSemaphore(int capacity) {
            // The casting results in a warning
            array = (T[]) new Object[capacity];
            this.capacity = capacity;
            this.semProducer = new CountingSemaphore(capacity, capacity);
            this.semConsumer = new CountingSemaphore(capacity, 0);
        }

        public T dequeue() throws InterruptedException {

            T item = null;

            semConsumer.acquire();
            semLock.acquire();

            if (head == capacity) {
                head = 0;
            }

            item = array[head];
            array[head] = null;
            head++;
            size--;

            semLock.release();
            semProducer.release();

            return item;
        }

        public void enqueue(T item) throws InterruptedException {

            semProducer.acquire();
            semLock.acquire();

            if (tail == capacity) {
                tail = 0;
            }

            array[tail] = item;
            size++;
            tail++;

            semLock.release();
            semConsumer.release();
        }
    }

    static class CountingSemaphore {

        int usedPermits = 0;
        int maxCount;

        public CountingSemaphore(int count) {
            this.maxCount = count;
        }

        public CountingSemaphore(int count, int initialPermits) {
            this.maxCount = count;
            this.usedPermits = this.maxCount - initialPermits;
        }

        public synchronized void acquire() throws InterruptedException {

            while (usedPermits == maxCount)
                wait();

            notify();
            usedPermits++;
        }

        public synchronized void release() throws InterruptedException {

            while (usedPermits == 0)
                wait();

            usedPermits--;
            notify();
        }
    }
}
