package com.company.codingscales.java.concepts.multithreading;

import java.util.concurrent.Callable;

public class CallableExample {
    class SumTask implements Callable<Integer> {
        int n;

        public SumTask(int n) {
            this.n = n;
        }

        @Override
        public Integer call() throws Exception {
            if (n <= 0)
                return 0;

            int sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += i;
            }

            return sum;
        }
    }
}
