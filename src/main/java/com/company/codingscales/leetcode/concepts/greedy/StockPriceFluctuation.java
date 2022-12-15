package com.company.codingscales.leetcode.concepts.greedy;

import java.util.HashMap;
import java.util.PriorityQueue;

public class StockPriceFluctuation {

    class Stock {
        int timestamp;
        int price;

        Stock(int t, int p) {
            this.timestamp = t;
            this.price = p;
        }
    }

    int currentTimestamp = Integer.MIN_VALUE;
    HashMap<Integer, Integer> tsToStockPrice;
    PriorityQueue<Stock> minHeap;
    PriorityQueue<Stock> maxHeap;

    public StockPriceFluctuation() {
        tsToStockPrice = new HashMap<>();

        minHeap = new PriorityQueue<Stock>((a, b) -> {
            return a.price - b.price;
        });

        maxHeap = new PriorityQueue<Stock>((a, b) -> {
            return b.price - a.price;
        });
    }

    public void update(int timestamp, int price) {
        currentTimestamp = Math.max(currentTimestamp, timestamp);
        tsToStockPrice.put(timestamp, price);

        minHeap.offer(new Stock(timestamp, price));
        maxHeap.offer(new Stock(timestamp, price));
    }

    public int current() {
        if (currentTimestamp == Integer.MIN_VALUE) return -1;

        return tsToStockPrice.get(currentTimestamp);
    }

    public int maximum() {
        if (maxHeap.isEmpty()) return -1;
        Stock current_maximum = maxHeap.peek();

        while (tsToStockPrice.get(current_maximum.timestamp) != current_maximum.price) { // remove obselete values
            maxHeap.poll();
            current_maximum = maxHeap.peek();
        }

        return current_maximum.price;
    }

    public int minimum() {
        if (minHeap.isEmpty()) return -1;
        Stock current_minimum = minHeap.peek();

        while (tsToStockPrice.get(current_minimum.timestamp) != current_minimum.price) {
            minHeap.poll();
            current_minimum = minHeap.peek();
        }

        return current_minimum.price;
    }
}
