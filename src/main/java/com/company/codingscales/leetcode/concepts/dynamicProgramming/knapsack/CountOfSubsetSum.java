package com.company.codingscales.leetcode.concepts.dynamicProgramming.knapsack;

public class CountOfSubsetSum {
    int dfs(int index, int[] nums, int total) {
        if (total == 0)
            return 1;

        if (index == nums.length) {
            return 0;
        }

        int ways = 0;
        if (nums[index] < total) {
            ways += dfs(index + 1, nums, total - nums[index]);
        }

        ways += dfs(index + 1, nums, total);
        return ways;
    }

    int solve(final int[] nums, int total) {
       return dfs(0, nums, total);
    }

    int solveBottomUp(final int[] nums, final int total) {
        final Integer[][] dp = new Integer[nums.length][total + 1];

        for(int i = 0; i < nums.length; i++) {
            dp[i][0] = 0;
        }

        for(int j = 1; j < total + 1; j++) {
            dp[0][j] = nums[0] == j ? 1 : 0; // always has the base cond of rec helper
        }

        for(int i = 1; i < nums.length; i++) {
            for(int j = 1; j < total + 1; j++) {
                dp[i][j] = dp[i-1][j];
                if (nums[i] <= j) {
                    dp[i][j] += dp[i - 1][j - nums[i]];
                }
            }
        }

        return dp[nums.length - 1][total];
    }
}
