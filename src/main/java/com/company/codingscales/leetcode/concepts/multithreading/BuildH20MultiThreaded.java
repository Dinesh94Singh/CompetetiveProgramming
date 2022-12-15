package com.company.codingscales.leetcode.concepts.multithreading;

public class BuildH20MultiThreaded {
    int hydrogen;
    Object lock;
    int count = 0;

    public BuildH20MultiThreaded() {
        lock = new Object();
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        synchronized (lock) {
            while (hydrogen == 2) {
                lock.wait();
            }

            count += 1;
            releaseHydrogen.run();
            hydrogen += 1;
            if (hydrogen == 2) {
                lock.notifyAll();
            }
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        synchronized (lock) {
            while (hydrogen < 2) {
                lock.wait();
            }

            count += 1;

            releaseOxygen.run();
            hydrogen = 0;
            lock.notifyAll();
        }
    }
}
