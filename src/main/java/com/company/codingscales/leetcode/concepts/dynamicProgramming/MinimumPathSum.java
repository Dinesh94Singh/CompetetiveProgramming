package com.company.codingscales.leetcode.concepts.dynamicProgramming;

public class MinimumPathSum {
    int[][] dp;
    public int minPathSum(final int[][] grid) {
        final int R = grid.length;
        final int C = R > 0 ? grid[0].length : 0;

        dp = new int[R][C];

        dp[R - 1][C - 1] = grid[R -1][C - 1];

        for(int i = R - 2; i >= 0; i--) {
            dp[i][C - 1] = dp[i + 1][C - 1] + grid[i][C - 1];
        }

        for(int i = C - 2; i >= 0; i--) {
            dp[R - 1][i] = dp[R - 1][i + 1] + grid[R - 1][i];
        }


        for(int i = R - 2; i >= 0; i--) {
            for(int j = C - 2; j >=0; j--) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + grid[i][j];
            }
        }


        return dp[0][0];
    }
}
