package com.company.codingscales.leetcode.concepts.dynamicProgramming.unboundedKnapsack;

public class CoinChange2 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            for (int x = coins[i]; x < amount + 1; ++x) {
                dp[x] += dp[x - coins[i]];
            }
        }

        return dp[amount];
    }
}
