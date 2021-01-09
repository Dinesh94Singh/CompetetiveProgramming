package com.company.codingscales.leetcode.concepts.dynamicProgramming.unboundedKnapsack;

import java.util.Arrays;

/**
 * Similar to {@link CoinChange2}
 */
public class PerfectSquares {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        int endIdx = (int) Math.sqrt(n) + 1;

        int[] A = new int[endIdx];

        for(int i = 1; i < endIdx; i++) {
            A[i] = i * i;
        }


        for(int i = 1; i < endIdx; i++) {
            for(int j = 1; j <= n; j++) {
                if (A[i] <= j)
                    dp[j] = Math.min(dp[j], dp[j - A[i]] + 1);
            }
        }

        return dp[n];
    }
}
