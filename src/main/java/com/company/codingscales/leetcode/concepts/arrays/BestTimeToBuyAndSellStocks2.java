package com.company.codingscales.leetcode.concepts.arrays;

public class BestTimeToBuyAndSellStocks2 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int valley = Integer.MAX_VALUE;

        int i = 0;
        while(i < prices.length) {
            // find the next valley
            while(i < prices.length - 1 && prices[i] > prices[i + 1]) {
                i++;
            }

            if (i == prices.length)
                break;
            valley = prices[i];

            // find the peak
            while(i < prices.length - 1 && prices[i] < prices[i + 1]) {
                i++;
            }

            if (i == prices.length)
                break;

            profit += (prices[i] - valley);
            i++;
        }

        return profit;
    }
}
