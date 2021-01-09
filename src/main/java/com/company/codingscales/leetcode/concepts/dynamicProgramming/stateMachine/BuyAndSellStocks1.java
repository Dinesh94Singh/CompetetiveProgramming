package com.company.codingscales.leetcode.concepts.dynamicProgramming.stateMachine;

/**
 * Refer for optimized sol {@link com.company.codingscales.leetcode.concepts.arrays.BestTimeToBuyAndSellStocks}
 */
public class BuyAndSellStocks1 {
    // More optimized see above link
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int prevProfit = 0;
        for(int i = 1; i < prices.length; i++) {
            int profit = Math.max(prices[i] - prices[i-1] + prevProfit, 0);
            maxProfit = Math.max(profit, maxProfit);
            prevProfit = profit;
        }

        return maxProfit;
    }
}
