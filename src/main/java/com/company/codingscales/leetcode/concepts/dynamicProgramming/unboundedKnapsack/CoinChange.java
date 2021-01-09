package com.company.codingscales.leetcode.concepts.dynamicProgramming.unboundedKnapsack;

import java.util.Arrays;

public class CoinChange {
    Integer[][] dp;

    int dfs(int index, int[] nums, int capacity) {
        if (capacity == 0)
            return 1;

        if (index == nums.length)
            return 0;

        if (dp[index][capacity] != null)
            return dp[index][capacity];

        int total = 0;
        if (nums[index] <= capacity) {
            total += dfs(index, nums, capacity - nums[index]);
        }

        total += dfs(index + 1, nums, capacity);
        dp[index][capacity] = total;
        return total;
    }

    int solve(final int[] nums, final int capacity) {
        final int n = nums.length;
        dp = new Integer[n][capacity + 1];
        return dfs(0, nums, capacity);
    }

    int solveBottomUp(final int[] nums, final int capacity) {
        final int n = nums.length;
        final Integer[][] dp = new Integer[n][capacity + 1];

        for(int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 1; j < capacity + 1; j++) {
                dp[i][j] = 0;

                if (i > 0) {
                    dp[i][j] += dp[i - 1][j];
                }

                if (nums[i] <= j) {
                    dp[i][j] += dp[i][j - nums[i]];
                }
            }
        }

        return dp[n - 1][capacity];
    }

    int solveBottomUpBetter(final int[] nums, final int amount) {
        int N = nums.length;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 1; j <= amount; j++) {
                if (nums[i] <= j) {
                    dp[j] = Math.min(dp[j], 1 + dp[j - nums[i]]);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
