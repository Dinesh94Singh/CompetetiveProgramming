package com.company.codingscales.leetcode.concepts.dynamicProgramming.knapsack;

import java.util.Arrays;

// You can Add / Subtract. Total number of ways to get the total.
/*
    can be done similar to count of subset sum => (1 + 3) - (1 + 2) = 1(capacity)
        * Sum(s1) + Sum(s2) = Sum(s)
        * Sum(s1) - Sum(s2) = Total

    from above two => Sum(s1) - Sum(s2) + Sum(s1) + Sum(s2) = capacity + Sum(num)
        2* Sum(s1) = capacity + Sum(num)
        Sum(s1) = (capacity + Sum(num)) / 2

        With Sum(s1) being the target, you can do count of subset problem from there.
 */
public class TargetSum {
    int solve(final int[] nums, int capacity) {
        final int totalSum = Arrays.stream(nums).reduce(0, Integer::sum);

        if (totalSum < capacity || (capacity + totalSum) % 2 == 1)
            return 0;

        final int n = nums.length;
        capacity = (capacity + totalSum) / 2; // from the above formulae
        final Integer[][] dp = new Integer[n][capacity + 1];

        for(int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for(int j = 1; j < capacity + 1; j++)
            dp[0][j] = nums[0] == j ? 1 : 0;

        for(int i = 1; i < n; i++)
            for(int j = 1; j < capacity + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                if (nums[i] <= j) {
                    dp[i][j] += dp[i-1][j - nums[i]];
                }
            }

        return dp[nums.length - 1][capacity];
    }
}
