package com.company.codingscales.leetcode.concepts.dynamicProgramming.fibanaciSeries;

import java.util.HashMap;

public class MinimumJumpsWithFee {
    static HashMap<Integer, Integer> dp = new HashMap<>();
    static int dfs(int index, int[] fee, int n) {
        if (index >= fee.length)
            return 0;

        if (dp.containsKey(index))
            return dp.get(index);

        int minimum = Integer.MAX_VALUE;

        minimum = Math.min(minimum, dfs(index + 1, fee, n - 1) + fee[index]);
        minimum = Math.min(minimum, dfs(index + 2, fee, n - 2) + fee[index]);
        minimum = Math.min(minimum, dfs(index + 3, fee, n - 3) + fee[index]);
        dp.put(index, minimum);
        return minimum;
    }

    static int findMinFee(int[] fee, int n) {
        if (n != fee.length)
            return -1;

        return dfs(0, fee, n);
    }

    static int findMinFeeBottomUp(int[] fee, int n) {
        Integer[] dp = new Integer[n + 1];
        dp[0] = 0;
        dp[1] = fee[0];
        dp[2] = fee[0];
        dp[3] = fee[0];

        for(int i = 3; i < fee.length; i++) {
            dp[i + 1] = Math.min(fee[i] + dp[i], fee[i - 1] + dp[i - 1] + fee[i - 2] + dp[i - 2]);
        }

        return dp[n];
    }
}
