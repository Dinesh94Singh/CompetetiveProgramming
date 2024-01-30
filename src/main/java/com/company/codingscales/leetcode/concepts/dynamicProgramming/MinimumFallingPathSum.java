package com.company.codingscales.leetcode.concepts.dynamicProgramming;

import java.util.*;

/**
 * MinimumFallingPathSum
 */
public class MinimumFallingPathSum {

    public int minFallingPathSum(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        int[][] dp = new int[R][C];

        for (int[] e : dp)
            Arrays.fill(e, Integer.MAX_VALUE);

        for (int i = 0; i < C; i++) {
            dp[0][i] = matrix[0][i];
        }

        for (int i = 1; i < R; i++) {
            for (int j = 0; j < C; j++) {

                int left = j == 0 ? Integer.MAX_VALUE : dp[i - 1][j - 1];
                int bottom = dp[i - 1][j];
                int right = j == C - 1 ? Integer.MAX_VALUE : dp[i - 1][j + 1];

                int total = matrix[i][j] + Math.min(left, Math.min(bottom, right));
                dp[i][j] = Math.min(dp[i][j], total);
            }
        }


        int min = Integer.MAX_VALUE;
        for (int i = 0; i < C; i++) {
            min = Math.min(min, dp[R - 1][i]);
        }

        return min;
    }
}
