package com.company.codingscales.leetcode.concepts.dynamicProgramming.fibanaciSeries;

import java.util.HashMap;

public class HouseThief {
    static HashMap<Integer, Integer> dp = new HashMap<>();

    static int dfs(int index, int[] amounts) {
        if (index == amounts.length)
            return 0;

        if (dp.containsKey(index))
            return dp.get(index);

        int maximum = Integer.MIN_VALUE;
        maximum = Math.max(maximum, dfs(index + 2, amounts) + amounts[index]);
        maximum = Math.max(maximum, dfs(index + 1, amounts));

        dp.put(index, maximum);

        return maximum;
    }

    static int findMaxSteal(int[] amounts) {
        return dfs(0, amounts);
    }

    static int findMaxStealBottomUp(int[] amounts) {
        Integer[] dp = new Integer[amounts.length + 1];
        dp[0] = 0;
        dp[1] = amounts[0];
        for(int i = 1; i < amounts.length + 1; i++)
            dp[i] = Integer.MIN_VALUE;

        for(int i = 2; i < amounts.length; i++) {
            dp[i] = Math.max(dp[i - 2] + amounts[i], dp[i - 1]);
        }

        return dp[amounts.length];
    }
}
