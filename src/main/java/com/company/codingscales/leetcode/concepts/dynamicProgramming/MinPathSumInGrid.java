package com.company.codingscales.leetcode.concepts.dynamicProgramming;

public class MinPathSumInGrid {
    public int minPathSum(final int[][] grid) {
        // cannot be greedy, because, if its gready it would pick [1][0]
        // should try all possibilities, you can move only down or right
        final int R = grid.length;
        final int C = R > 0 ? grid[0].length : 0;

        final int[][] dp = new int[R][C];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < R; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for (int i = 1; i < C; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }

        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[R-1][C-1];
    }
}
