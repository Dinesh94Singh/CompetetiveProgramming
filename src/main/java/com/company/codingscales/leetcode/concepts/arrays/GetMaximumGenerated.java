package com.company.codingscales.leetcode.concepts.arrays;

public class GetMaximumGenerated {
    public int getMaximumGenerated(int n) {
        if (n == 0)
            return 0;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        if (n < 2)
            return dp[n];

        int max = 1;
        for(int i = 1; i <= (n / 2); i++) {
            dp[2 * i] = dp[i];
            max = Math.max(max, dp[2 * i]);

            if (2*i + 1 <= n) {
                dp[2 * i + 1] = dp[i] + dp[i + 1];
                max = Math.max(max, dp[2 * i + 1]);
            }

        }

        for(int i = 0; i < n; i++)
            System.out.printf("\t %d",  dp[i]);

        return max;
    }
}
