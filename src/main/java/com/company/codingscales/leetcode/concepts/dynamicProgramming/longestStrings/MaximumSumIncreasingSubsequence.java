package com.company.codingscales.leetcode.concepts.dynamicProgramming.longestStrings;

import java.util.HashMap;

public class MaximumSumIncreasingSubsequence {
    static HashMap<String, Integer> dp = new HashMap<>();
    static int dfs(int index, int prevIndex, int[] nums, int sum) {
        if (index == nums.length)
            return sum;

        final String key = index + "-" + prevIndex + "-" + sum;
        if (dp.containsKey(key))
            return dp.get(key);

        int maximum = Integer.MIN_VALUE;
        if (nums[index] > nums[prevIndex]) {
            maximum = Math.max(maximum, dfs(index + 1, index, nums, sum - nums[index]));
        }

        maximum = Math.max(maximum, dfs(index + 1, index, nums, sum));
        dp.put(key, maximum);
        return maximum;
    }

    static int maximumSumIncreasingSubSequence(int[] nums) {
        return dfs(0, -1, nums, 0);
    }

    // new pattern to note down in dp notes, where we check for j --> i window and find the res
    static int maximumSumIncreasingSubSequenceDp(int[] nums) {
        final int[] dp = new int[nums.length];
        dp[0] = nums[0];

        int maximumSum = nums[0];

        for(int i = 1; i < nums.length; i++) {
            dp[i] = nums[i];

            for(int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + nums[i])
                    dp[i] = dp[j] + nums[i];
            }
            maximumSum = Math.max(maximumSum, dp[i]);
        }

        return maximumSum;
    }
}
