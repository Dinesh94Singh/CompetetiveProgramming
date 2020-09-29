package com.company.codingscales.leetcode.concepts.dynamicProgramming.unboundedKnapsack;

import java.util.Arrays;

public class UnboundedKnapSack {
    int[][] dp;
    int dfs(final int index, final int[] weights, final int[] profits, final int capacity) {
        if (index == weights.length)
            return 0;
        if (capacity == 0)
            return 0;

        if (dp[index][capacity] != -1)
            return dp[index][capacity];

        int ret = Integer.MIN_VALUE;
        if (weights[index] <= capacity) {
            ret = Math.max(ret, dfs(index, weights, profits, capacity - weights[index]) + profits[index]);
        }

        ret = Math.max(ret, dfs(index + 1, weights, profits, capacity));

        dp[index][capacity] = ret;
        return ret;
    }

    int solve(final int[] weights, final int[] profits, final int capacity) {
        final int N = weights.length;
        dp = new int[N][capacity + 1];

        for(final int[] each : dp) {
            Arrays.fill(each, -1);
        }

        return dfs(0, weights, profits, capacity);
    }

    // f(i, j) = max(f(i-1,j), f(i, j - weights[i]) + profits[i])
    int solveBottomUp(final int[] weights, final int[] profits, final int capacity) {
        final int n = weights.length;
        final int[][] dp = new int[n][capacity + 1];

        for(int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }

        for(int i = 0; i < n; i++) { // changed from i = 1, to zero.
            for(int j = 1; j <= capacity; j++) {
                if (weights[i] <= j) {
                    dp[i][j] = profits[i] + dp[i][j - weights[i]];
                }
                if (i > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j-1]);
                }
            }
        }

        return dp[n - 1][capacity];
    }
}
