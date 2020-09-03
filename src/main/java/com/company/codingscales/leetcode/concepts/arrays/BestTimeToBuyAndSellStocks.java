package com.company.codingscales.leetcode.concepts.arrays;

public class BestTimeToBuyAndSellStocks {
    public int maxProfit(int[] prices) {
        int res = Integer.MIN_VALUE;
        int valley = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++) {
            if (prices[i] < valley) {
                valley = prices[i];
            } else if (valley != Integer.MIN_VALUE && prices[i] > valley) {
                res = Math.max(res, prices[i] - valley);
            }
        }

        if (res == Integer.MIN_VALUE)
            return 0;
        return res;
    }
}
