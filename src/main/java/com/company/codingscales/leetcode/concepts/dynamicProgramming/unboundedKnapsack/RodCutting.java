package com.company.codingscales.leetcode.concepts.dynamicProgramming.unboundedKnapsack;

public class RodCutting {
    int solve(final int[] lengths, final int[] prices, final int capacity) {
        final int n = lengths.length;
        final Integer[][] dp = new Integer[n][capacity + 1];

        for(int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 1; j < capacity + 1; j++) {
                if (i > 0) {
                    dp[i][j] = dp[i - 1][j];
                }

                if (lengths[i] <= j) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - lengths[i]] + prices[i]);
                }
            }
        }

        return dp[prices.length - 1][capacity];
    }
}
