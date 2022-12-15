package com.company.codingscales.leetcode.concepts.multithreading;

import java.util.function.IntConsumer;

class MultithreadedFizzBuzz {
    private int n;
    private int num = 1;

    public MultithreadedFizzBuzz(int n) {
        this.n = n;
    }

    public synchronized void fizz() throws InterruptedException {
        while (num <= n) {
            if (num % 3 == 0 && num % 5 != 0) {
                System.out.println("Fizz");
                num++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void buzz() throws InterruptedException {
        while (num <= n) {
            if (num % 3 != 0 && num % 5 == 0) {
                System.out.println("Buzz");
                num++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void fizzbuzz() throws InterruptedException {
        while (num <= n) {
            if (num % 15 == 0) {
                System.out.println("FizzBuzz");
                num++;
                notifyAll();
            } else {
                wait();
            }
        }
    }

    public synchronized void number() throws InterruptedException {
        while (num <= n) {
            if (num % 3 != 0 && num % 5 != 0) {
                System.out.println(num);
                num++;
                notifyAll();
            } else {
                wait();
            }
        }
    }
}

class MultiThreadedFizzBuzzWithSyncrhonizedBlock {
    class FizzBuzz {
        private int n;
        int current;

        Object lock =  new Object();

        public FizzBuzz(int n) {
            this.n = n;
            this.current = 1;
        }

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            while (current <= n) {
                synchronized(lock) {
                    if (current % 3 != 0 || current % 5 == 0) {
                        lock.wait();
                        continue;
                    }

                    current += 1;
                    printFizz.run();
                    lock.notifyAll();
                }
            }
        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            while (current <= n) {
                synchronized(lock) {
                    if (current % 5 != 0 || current % 3  == 0) {
                        lock.wait();
                        continue;
                    }

                    current +=  1;
                    printBuzz.run();
                    lock.notifyAll();
                }
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            while (current <= n) {
                synchronized(lock) {
                    if (!(current % 5 == 0 && current % 3 == 0))  {
                        lock.wait();
                        continue;
                    }

                    printFizzBuzz.run();
                    current += 1;
                    lock.notifyAll();
                }
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            while (current <= n) {
                synchronized(lock) {
                    if (current % 5 == 0 || current % 3 == 0) {
                        lock.wait();
                        continue;
                    }

                    printNumber.accept(current);
                    current += 1;
                    lock.notifyAll();
                }
            }
        }
    }
}

class FizzBuzzThread extends Thread {

    MultithreadedFizzBuzz obj;
    String method;

    public FizzBuzzThread(MultithreadedFizzBuzz obj, String method) {
        this.obj = obj;
        this.method = method;
    }

    public void run() {
        if ("Fizz".equals(method)) {
            try {
                obj.fizz();
            } catch (Exception e) {
            }
        } else if ("Buzz".equals(method)) {
            try {
                obj.buzz();
            } catch (Exception e) {
            }
        } else if ("FizzBuzz".equals(method)) {
            try {
                obj.fizzbuzz();
            } catch (Exception e) {
            }
        } else if ("Number".equals(method)) {
            try {
                obj.number();
            } catch (Exception e) {
            }
        }

    }
}

class FizzBuzzMultiThreaded {
    public static void main(String[] args) {
        MultithreadedFizzBuzz obj = new MultithreadedFizzBuzz(15);

        Thread t1 = new FizzBuzzThread(obj, "Fizz");
        Thread t2 = new FizzBuzzThread(obj, "Buzz");
        Thread t3 = new FizzBuzzThread(obj, "FizzBuzz");
        Thread t4 = new FizzBuzzThread(obj, "Number");

        t2.start();
        t1.start();
        t4.start();
        t3.start();
    }
}