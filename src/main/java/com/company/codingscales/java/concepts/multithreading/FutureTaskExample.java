package com.company.codingscales.java.concepts.multithreading;

import java.util.concurrent.*;

public class FutureTaskExample {
    @SuppressWarnings("unchecked")
    public static void main(String args[]) throws Exception {
        FutureTask<Integer> futureTask = new FutureTask(new Callable() {
            public Object call() throws Exception {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ie) {
                    // swallow exception
                }
                return 5;
            }
        });

        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        Future duplicateFuture = threadPool.submit(futureTask);

        // Awful idea to busy wait
        while (!futureTask.isDone()) {
            System.out.println("Waiting");
        }

        if (duplicateFuture.isDone() != futureTask.isDone()) {
            System.out.println("This should never happen.");
        }

        System.out.println((int) futureTask.get());

        threadPool.shutdown();
    }
}
