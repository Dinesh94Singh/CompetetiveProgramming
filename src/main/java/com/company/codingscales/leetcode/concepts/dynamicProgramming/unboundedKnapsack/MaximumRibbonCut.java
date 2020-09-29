package com.company.codingscales.leetcode.concepts.dynamicProgramming.unboundedKnapsack;

public class MaximumRibbonCut {
    int solve(final int[] ribbonLengths, final int capacity) {
        final int n = ribbonLengths.length;
        int[][] dp = new int[n][capacity + 1];

        for(int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }

        for(int i =0; i < n; i++) {
            for(int j = 1; j < capacity + 1; j++) {
                dp[i][j] = Integer.MIN_VALUE;
                if (i > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                }

                if (ribbonLengths[i] <= j) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - ribbonLengths[i]] + 1);
                }
            }
        }

        return dp[n-1][capacity];
    }
}
