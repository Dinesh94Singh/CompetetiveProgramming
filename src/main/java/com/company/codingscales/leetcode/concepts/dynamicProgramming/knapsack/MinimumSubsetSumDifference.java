package com.company.codingscales.leetcode.concepts.dynamicProgramming.knapsack;

import java.util.Arrays;

public class MinimumSubsetSumDifference { // ideally, i would take heap and add numbers to this.
    int[][] dp;

    // you don't need the third state and make it 3d dp, because, total - s1 => s2, you can derive the state from total.
    int dfs(final int index, final int[] nums, final int s1, final int s2) {
        if (index == nums.length)
            return Math.abs(s1 - s2);
        if (dp[index][s1] != -1)
            return dp[index][s1];

        final int first = dfs(index + 1, nums, s1 + nums[index], s2);
        final int second = dfs(index + 1, nums, s1, s2 + nums[index]);

        dp[index][s1] = Math.min(first, second);
        return dp[index][s1];
    }

    int solve(final int[] nums) {
        final int total = Arrays.stream(nums).reduce(0, Integer::sum);
        dp = new int[nums.length][total];
        return dfs(0, nums, 0, 0);
    }

    /*
        Search for sum equal to total / 2. Normally, you can do like equal subset sum partition as well.
     */
    int solveBottomUp(final int[] nums) {
        int total = Arrays.stream(nums).reduce(0, Integer::sum);
        total /= 2; // We should try to target total/2, that's where, they will have a min difference (if equal, min diff = 0)
        final Boolean[][] dp = new Boolean[nums.length][total + 1];

        for(int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }

        for(int j = 1; j < total + 1; j++) {
            dp[0][j] = (j == nums[0]);
        }

        for(int i = 1; i < nums.length; i++) {
            for(int j = 1; j < total + 1; j++) {
                if (dp[i-1][j]) {
                    dp[i][j] = true;
                } else if (nums[i] <= j) {
                    dp[i][j] = dp[i-1][j - nums[i]];
                }
            }
        }

        int sum1 = 0;
        final int n = nums.length;
        for(int i = total / 2; i >= 0; i--) {
            if (dp[n - 1][i]) {
                sum1 = i;
                break;
            }
        }

        int sum2 = total - sum1;
        return Math.abs(sum1 - sum2);
    }
}
