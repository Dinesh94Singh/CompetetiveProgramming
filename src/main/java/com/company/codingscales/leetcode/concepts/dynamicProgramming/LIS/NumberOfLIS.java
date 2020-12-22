package com.company.codingscales.leetcode.concepts.dynamicProgramming.LIS;

import java.util.Arrays;

public class NumberOfLIS {
    public int findNumberOfLIS(final int[] nums) {
        int n = nums.length, res = 0, max_len = 0;
        int[] dp =  new int[n], cnt = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(cnt, 1);

        for(int i = 0; i < n; i++){
            dp[i] = cnt[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    if(dp[i] == dp[j] + 1) // if equal length
                        cnt[i] += cnt[j]; // add maxLength + 1
                    if(dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j]; // contains the maxLength so far
                    }
                }
            }

            if(max_len == dp[i])
                res += cnt[i];
            if(max_len < dp[i]) {
                max_len = dp[i];
                res = cnt[i]; // reset count
            }
        }
        return res;
    }
}
