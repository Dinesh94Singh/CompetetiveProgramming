package com.company.codingscales.leetcode.concepts.dynamicProgramming.fibanaciSeries;

import java.util.HashMap;

public class StairCase {
    HashMap<Integer, Integer> dp = new HashMap<>();
    int dfs(int n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;

        if (dp.containsKey(n))
            return dp.get(n);

        int ret = 0;
        ret += dfs(n-1);
        ret += dfs(n - 2);
        ret += dfs(n - 3);

        dp.put(n, ret);
        return ret;
    }
    int stairCase(int n) {
        // can make 1, 2, 3 steps
        return dfs(n);
    }

    int startCaseBottomUp(int n) { // for space optimizations, use temp variables like fibanacci series
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[n];
    }
}
