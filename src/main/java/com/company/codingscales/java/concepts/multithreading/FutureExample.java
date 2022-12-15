package com.company.codingscales.java.concepts.multithreading;

import java.util.concurrent.*;

public class FutureExample {
    // Create and initialize a thread-pool
    static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String args[]) throws Exception {
        System.out.println("sum :" + findSum(10));
        threadPool.shutdown();
    }

    static int findSum(final int n) throws ExecutionException, InterruptedException {
        Callable<Integer> sumTask = new Callable<Integer>() {
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 1; i <= n; i++)
                    sum += i;
                return sum;
            }
        };

        Future<Integer> f = threadPool.submit(sumTask);
        threadPool.submit(() -> {
           // this is a task;
        });
        return f.get();
    }
}
