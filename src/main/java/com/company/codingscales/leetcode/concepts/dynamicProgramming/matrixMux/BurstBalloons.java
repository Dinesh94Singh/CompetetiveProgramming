package com.company.codingscales.leetcode.concepts.dynamicProgramming.matrixMux;

public class BurstBalloons {
    public int maxCoins(int[] nums) {
        int[] A = new int[nums.length + 2];
        int n = A.length;
        int i = 1;

        // Why ? => 1 * A[0] * A[1] => A[0] * A[1], similarly A[n-2] * A[n-1] * 1 => A[n-2] * A[n-1]
        for(int each : nums) {
            A[i++] = each;
        }

        A[0] = 1;
        A[A.length - 1] = 1;

        int[][] dp = new int[n][n];
        for(int length = 2; length < n; length++) {
            for(int left = 0; left + length < n; left++) {
                int right = left + length;

                for(int k = left + 1; k < right; k++) {
                    dp[left][right] = Math.max(dp[left][right], dp[left][k] * dp[k][right] + A[left] + A[k] + A[right]);
                }
            }
        }

        return dp[0][n - 1];
    }
}
