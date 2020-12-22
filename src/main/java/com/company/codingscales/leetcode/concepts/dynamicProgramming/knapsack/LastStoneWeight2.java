package com.company.codingscales.leetcode.concepts.dynamicProgramming.knapsack;

import java.util.Arrays;

/**
 * Similar to {@link MinimumSubsetSumDifference}
 */
public class LastStoneWeight2 {
    public int lastStoneWeight2(int[] A) {
        int total = Arrays.stream(A).reduce(0, Integer::sum);
        boolean[] dp = new boolean[total + 1];
        dp[0] = true;
        int sumA = 0;
        for (int a : A) {
            for (int i = total; i >= a; --i)
                dp[i] |= dp[i - a];
        }
        for (int i = total / 2; i >= 0; --i)
            if (dp[i]) return total - i - i;
        return 0;
    }
}
