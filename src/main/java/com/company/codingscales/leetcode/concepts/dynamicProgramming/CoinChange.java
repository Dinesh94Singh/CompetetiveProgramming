package com.company.codingscales.leetcode.concepts.dynamicProgramming;

import java.util.Arrays;

public class CoinChange {
    int[][] dp;

    int recHelper(int index, int[] coins, int remAmount) {
        if (remAmount == 0)
            return 0;

        if (index == coins.length)
            return Integer.MAX_VALUE;

        if (dp[index][remAmount] != 0)
            return dp[index][remAmount];

        int res = Integer.MAX_VALUE;
        if (coins[index] <= remAmount) {
            int t = recHelper(index, coins, remAmount - coins[index]);
            if (t != Integer.MAX_VALUE)
                res = Math.min(res, t + 1);
        }

        res = Math.min(res, recHelper(index + 1, coins, remAmount));
        dp[index][remAmount] = res;
        return res;
    }

    public int coinChange(int[] coins, int amount) {
        int N = coins.length;
        dp = new int[N][amount + 1];
        int t = recHelper(0, coins, amount);
        if (t == Integer.MAX_VALUE)
            return -1;
        return t;
    }

    private int coinChangeBottomUp(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (final int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
