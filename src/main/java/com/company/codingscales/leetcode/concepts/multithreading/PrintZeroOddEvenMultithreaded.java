package com.company.codingscales.leetcode.concepts.multithreading;

import java.util.function.IntConsumer;

public class PrintZeroOddEvenMultithreaded {
    private int n;
    Object lock = new Object();
    int count = 1;
    boolean should_print = true;

    public PrintZeroOddEvenMultithreaded(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (count <= n) {
            synchronized (lock) {
                if (!should_print) {
                    lock.wait();
                    continue;
                }

                should_print = false;
                printNumber.accept(0);
                lock.notifyAll();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (count <= n) {
            synchronized (lock) {
                if (should_print || count % 2 != 0) {
                    lock.wait();
                    continue;
                }

                printNumber.accept(count);
                count = count + 1;
                should_print = !should_print;
                lock.notifyAll();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (count <= n) {
            synchronized (lock) {
                if (should_print || count % 2 == 0) {
                    lock.wait();
                    continue;
                }

                printNumber.accept(count);
                count = count + 1;
                should_print = !should_print;
                lock.notifyAll();
            }
        }
    }
}
