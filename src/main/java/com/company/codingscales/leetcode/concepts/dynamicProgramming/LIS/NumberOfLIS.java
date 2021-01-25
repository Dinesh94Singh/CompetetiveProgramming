package com.company.codingscales.leetcode.concepts.dynamicProgramming.LIS;

import java.util.Arrays;

public class NumberOfLIS {
    public int findNumberOfLIS(final int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] count = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int maximum = 1;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[i] == dp[j] + 1) {
                        count[i] += count[j];
                    } else if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }
                }
            }

            maximum = Math.max(maximum, dp[i]);
        }

        int res = 0;
        for(int i = 0; i < n; i++)
            if (maximum == dp[i])
                res += count[i];

        return res;
    }
}
