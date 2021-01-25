package com.company.codingscales.leetcode.concepts.dynamicProgramming.stateMachine;

/**
 * For better sol refer to {@link com.company.codingscales.leetcode.concepts.arrays.BestTimeToBuyAndSellStocks2}
 */
// Able to make as many transactions as possible
public class BuyAndSellStocks2 {
    public int maxProfitDP(int[] prices, int fee) {
        int cash = 0, hold = -prices[0];
        for(int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }
}
