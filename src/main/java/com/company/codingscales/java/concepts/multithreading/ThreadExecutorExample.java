package com.company.codingscales.java.concepts.multithreading;

import java.util.concurrent.Executor;

public class ThreadExecutorExample {
    public static void main(String args[]) {
        DumbExecutor myExecutor = new DumbExecutor();
        MyTask myTask = new MyTask();
        myExecutor.execute(myTask);
    }

    static class DumbExecutor implements Executor {
        // Takes in a runnable interface object
        public void execute(Runnable runnable) {
            Thread newThread = new Thread(runnable);
            newThread.start();
        }
    }

    static class MyTask implements Runnable {
        public void run() {
            System.out.println("Mytask is running now ...");
        }
    }
}
