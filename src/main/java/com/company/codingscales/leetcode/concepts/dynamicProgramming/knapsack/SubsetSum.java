package com.company.codingscales.leetcode.concepts.dynamicProgramming.knapsack;

import java.util.Arrays;

public class SubsetSum {
    Boolean[][] dp;
    boolean dfs(final int index, final int[] nums, final int capacity) {
        if(index == nums.length || nums[index] > capacity) {
            return false;
        }

        if (dp[index][capacity] != null)
            return dp[index][capacity];

        boolean ret = false;
        if (nums[index] <= capacity) {
            ret |= dfs(index + 1, nums, capacity - nums[index]);
        }

        ret |= dfs(index + 1, nums, capacity);

        dp[index][capacity] = ret;
        return ret;
    }

    boolean solve(final int[] nums, final int capacity) {
        dp = new Boolean[nums.length][capacity + 1];
        Arrays.sort(nums);
        return dfs(0, nums, capacity);
    }

    static boolean solveBottomUp(final int[] nums, final int capacity) {
        final Boolean[][] dp = new Boolean[nums.length][capacity + 1];
        for(int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }

        for(int j = 1; j < capacity + 1; j++) {
            dp[0][j] = (j == nums[0]);
        }

        for(int i = 1; i < nums.length; i++) {
            for(int j = 1; j <= capacity; j++) {
                if (dp[i - 1][j]) {
                    dp[i][j] = true;
                } else if (nums[i] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i]];
                }
            }
        }

        return dp[nums.length - 1][capacity];
    }
}
