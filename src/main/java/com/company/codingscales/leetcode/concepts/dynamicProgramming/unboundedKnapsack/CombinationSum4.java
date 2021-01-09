package com.company.codingscales.leetcode.concepts.dynamicProgramming.unboundedKnapsack;

/**
 * Similar to {@link CoinChange2}
 */
public class CombinationSum4 {
    public int combinationSum4(int[] A, int T) {
        // same as coin change 2
        int[] dp = new int[T + 1];
        dp[0] = 1;

        for (int j = 1; j <= T; j++) { // the amount is from 1 till T (inclusive)
            for (int each : A) {
                if (j - each >= 0)
                    dp[j] += dp[j - each];
            }
        }

        return dp[T];
    }
}
