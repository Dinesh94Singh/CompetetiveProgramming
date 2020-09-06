package com.company.codingscales.leetcode.concepts.dynamicProgramming;

import java.util.Arrays;

public class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] grid) {
        int R = grid.length;
        int C = R > 0 ? grid[0].length : 0;

        if (grid[0][0] == 1 || grid[R -1][C - 1] == 1)
            return 0;

        int[][] dp = new int[R][C];
        for(int[] each : dp)
            Arrays.fill(each, 0);

        for(int i = 0; i < R; i++) {
            if (grid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }

        for(int i = 0; i < C; i++) {
            if (grid[0][i] == 1) {
                break;
            }
            dp[0][i] = 1;
        }

        for(int i = 1; i < R; i++) {
            for(int j = 1; j < C; j++) {
                if (grid[i][j] == 1)
                    continue;
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[R-1][C-1];
    }
}
