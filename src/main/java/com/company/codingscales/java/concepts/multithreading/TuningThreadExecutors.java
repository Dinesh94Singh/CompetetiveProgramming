package com.company.codingscales.java.concepts.multithreading;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class TuningThreadExecutors {
    void receiveAndExecuteClientOrdersBest() {
        int expectedConcurrentOrders = 100;
        Executor executor = Executors.newFixedThreadPool(expectedConcurrentOrders);

        while (true) {
            final Order order = waitForNextOrder();

            executor.execute(new Runnable() {

                public void run() {
                    order.execute();
                }
            });
        }
    }

    Order waitForNextOrder() {
        return new Order();
    }

    static class Order {
        void execute() {}
    }
}
