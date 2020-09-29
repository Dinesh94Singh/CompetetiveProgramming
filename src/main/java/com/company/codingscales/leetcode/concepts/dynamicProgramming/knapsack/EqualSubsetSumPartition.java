package com.company.codingscales.leetcode.concepts.dynamicProgramming.knapsack;

import java.util.Arrays;

public class EqualSubsetSumPartition {
    int[][] dp;

    int dfs(final int index, final int[] nums, final int capacity) {
        if (capacity == 0)
            return 1;

        if (index == nums.length)
            return -1;

        if (dp[index][capacity] != -1)
            return dp[index][capacity];

        if (nums[index] <= capacity && dfs(index + 1, nums, capacity - nums[index]) == 1) {
            dp[index][capacity] = 1;
            return dp[index][capacity];
        }

        dp[index][capacity] = dfs(index + 1, nums, capacity);
        return dp[index][capacity];
    }

    boolean solve(final int[] nums) {
        final int total = Arrays.stream(nums).reduce(0, Integer::sum);
        if (total % 2 != 0)
            return false;

        dp = new int[nums.length][total / 2 + 1];
        for(final int[] each : dp) {
            Arrays.fill(each, -1);
        }
        return dfs(0, nums, total / 2) == 1;
    }

    // f(i, j) => if f(i-1)(j) => true, then f(i,j) = true. Else f(i-1, j - nums[i])
    static boolean solveTopDown(final int[] nums) {
        final int total = Arrays.stream(nums).reduce(0, Integer::sum);
        if (total % 2 != 0)
            return false;

        final int capacity = total / 2 + 1;
        final Boolean[][] dp = new Boolean[nums.length][capacity];

        for(int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }

        for(int j = 1; j <= capacity; j++) {
            dp[0][j] = nums[0] == j;
        }

        for(int i = 1; i < nums.length; i++) {
            for(int j = 1; j <= capacity; j++) {
                dp[i][j] = dp[i-1][j];
                if (dp[i - 1][j]) {
                    dp[i][j] = true;
                } else if (nums[i] <= capacity) {
                    dp[i][j] = dp[i-1][j - nums[i]];
                }
            }
        }

        return dp[nums.length - 1][capacity - 1];
    }
}
