package com.company.codingscales.leetcode.concepts.dynamicProgramming.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Similar to {@link LongestIncreasingSubsequence}
 */
public class LargestDivisibleSubset {
    // If nums[i] % nums[j] == 0, then it is valid. Find the longest such subsequence
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int N = nums.length;
        if (N == 0)
            return Collections.emptyList();
        int[] dp = new int[N];
        Arrays.fill(dp, 1); // base case. Min length would at-least be 1.

        for(int i = 1; i < N; i++) {
            for(int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        int maxIndex = 0;
        for(int i = 1; i < N; i++) {
            if (dp[maxIndex] < dp[i]) {
                maxIndex = i;
            }
        }

        int temp = nums[maxIndex];
        int lis = dp[maxIndex];
        for(int i = maxIndex; i >= 0; i--) {
            if (temp % nums[i] == 0 && lis == dp[i]) {
                res.add(nums[i]);
                temp = nums[i];
                lis--;
            }
        }

        return res;
    }
}
