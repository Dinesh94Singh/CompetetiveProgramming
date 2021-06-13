package com.company.codingscales.leetcode.concepts.dynamicProgramming.LIS;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    static int[][] dp;
    static int dfs(int[] nums, int index, int prevIndex) {
        if (index == nums.length)
            return 1;

        if (nums[prevIndex] < nums[index] || prevIndex == -1) {
            dp[index][prevIndex] = 1 + dfs(nums, index + 1, index);
        }

        dp[index][prevIndex] = Math.max(dp[index][prevIndex], dfs(nums, index + 1, prevIndex));
        return dp[index][prevIndex];
    }

    static int LIS(int[] nums) {
        dp = new int[nums.length][nums.length];
        return dfs(nums, 0, -1);
    }

    static int LISBottomUp(int[] nums) {
        final int dp[] = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxLength = Integer.MIN_VALUE;

        for(int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                    maxLength = Math.max(maxLength, dp[i]);
                }
            }
        }

        return maxLength;
    }
}
