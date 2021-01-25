package com.company.codingscales.leetcode.concepts.dynamicProgramming.stateMachine;

public class BuyAndSellStocks3 {
    public int maxProfit(int[] prices) {
        // at most 2 transactions -> can be done similar to at most k transactions where k == 2
        int N = prices.length;

        int leftMin = prices[0];
        int rightMax = prices[N - 1];

        int[] leftProfits = new int[N];
        int[] rightProfits = new int[N + 1];

        // Similar to Trapping Rain water DP.
        for(int l = 1; l < N; ++l) {
            leftProfits[l] = Math.max(prices[l] - leftMin, leftProfits[l - 1]);
            leftMin = Math.min(leftMin, prices[l]);

            int r = N - l - 1;
            rightProfits[r] = Math.max(rightProfits[r + 1], rightMax - prices[r]);
            rightMax = Math.max(rightMax, prices[r]);
        }

        int maxProfit = 0;
        for(int i = 0; i < N; i++) {
            maxProfit = Math.max(maxProfit, leftProfits[i] + rightProfits[i + 1]);
        }

        return maxProfit;
    }
}
