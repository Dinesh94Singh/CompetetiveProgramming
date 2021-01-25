package com.company.codingscales.leetcode.concepts.dynamicProgramming.stateMachine;

public class BuyAndSellStocksWithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        // maxProfit gained - (totalTransactionsMade / 2 * fee)
        int cash = 0, hold = -prices[0];
        for(int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }

        return cash;
    }
}
