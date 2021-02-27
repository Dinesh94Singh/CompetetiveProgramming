package com.company.codingscales.leetcode.concepts.dynamicProgramming;

public class HouseRobber {
    public int rob(int[] A) {
        int N = A.length;
        if (N == 0)
            return 0;
        if (N == 1)
            return A[0];
        int[] dp = new int[N + 1];

        dp[0] = A[0];
        dp[1] = Math.max(A[0], A[1]);

        for(int i = 2; i < N; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + A[i]);
        }

        return dp[N - 1];
    }
}
