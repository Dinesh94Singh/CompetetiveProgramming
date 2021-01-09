package com.company.codingscales.leetcode.concepts.dynamicProgramming.matrixMux;

public class MinimumCostTreeToLeafNode {
    public int minimumCostTreeFromLeafValues(int[] A) {
        int n = A.length;

        int[][] dp = new int[n][n];
        int[][] max = new int[n][n];

        for(int i = 0; i < n; i++) {
            int localMax = Integer.MIN_VALUE;

            for(int j = i; j < n; j++) {
                if (A[j] > localMax) {
                    localMax = A[j];
                }
                max[i][j] = localMax;
            }
        }

        for(int len = 1; len < n; len++) {
            for(int left = 0; left + len < n; left++) {
                int right = left + len;

                dp[left][right] = Integer.MAX_VALUE;

                if (len == 1) {
                    dp[left][right] = A[left] * A[right];
                } else {
                    for(int k = left; k < right; k++) {
                        dp[left][right] = Math.min(dp[left][right], dp[left][k] + dp[k + 1][right] + max[left][k] * max[k + 1][right]);
                    }
                }
            }
        }

        return dp[0][n - 1];
    }
}
