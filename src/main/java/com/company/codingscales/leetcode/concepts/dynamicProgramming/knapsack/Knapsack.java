package com.company.codingscales.leetcode.concepts.dynamicProgramming.knapsack;

import java.util.Arrays;

public class Knapsack {
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
            ret = Math.max(ret, dfs(index + 1, weights, profits, capacity - weights[index]) + profits[index]);
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

    // f(i, c) = max(f(i-1, c), profits[i] + f(i-1, c-weights[i])
    // c = capacity

    static int solve_BottomUp(final int[] weights, final int[] profits, final int capacity) {
        final Integer[][] dp = new Integer[weights.length][capacity + 1];
        for(int i = 0; i < weights.length; i++) {
            dp[i][0] = 0;
        }

        for(int j = 1; j <= capacity; j++) {
            dp[0][j] = profits[0];
        }

        for(int i = 1; i < weights.length; i++) {
            for(int j = 1; j <= capacity; j++) {
                dp[i][j] = dp[i - 1][j];
                if (weights[i] <= j) {
                    dp[i][j] = Math.max(dp[i][j] , profits[i] + dp[i-1][j - weights[i]]);
                }
            }
        }

        return dp[weights.length - 1][capacity];
    }

    public static void main(String[] args) {
    }
}
