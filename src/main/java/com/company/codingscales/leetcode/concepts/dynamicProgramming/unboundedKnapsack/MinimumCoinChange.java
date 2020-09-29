package com.company.codingscales.leetcode.concepts.dynamicProgramming.unboundedKnapsack;

public class MinimumCoinChange {
    Integer[][] dp;
    int dfs(final int index, final int[] nums, final int capacity) {
        if (capacity == 0)
            return 0;

        if (dp[index][capacity] != null)
            return dp[index][capacity];

        int minimum = Integer.MAX_VALUE;
        if (nums[index] <= capacity) {
            minimum = Math.min(minimum, dfs(index, nums, capacity - nums[index]) + 1);
        }

        minimum = Math.min(minimum, dfs(index + 1, nums, capacity));
        dp[index][capacity] = minimum;
        return minimum;
    }

    int solve(int[] nums, int capacity) {
        final int n = nums.length;
        dp = new Integer[n][capacity + 1];
        return dfs(0, nums, capacity);
    }

    int solveBottomUp(int[] nums, int capacity) {
        final int n = nums.length;
        dp = new Integer[n][capacity + 1];

        for(int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 1; j < capacity + 1; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                if (nums[i] <= j) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - nums[i]] + 1);
                }

                if (i > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j]);
                }
            }
        }

        return dp[n-1][capacity];
    }
}
