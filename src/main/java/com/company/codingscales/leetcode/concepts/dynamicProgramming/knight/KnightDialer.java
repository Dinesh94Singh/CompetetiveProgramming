package com.company.codingscales.leetcode.concepts.dynamicProgramming.knight;

public class KnightDialer {
    int[][] dirs = {
            {-1, -2},
            {-2, -1},
            {-2, 1},
            {-1, 2},
            {1, 2},
            {2, 1},
            {2, -1},
            {1, -2}
    };

    Integer[][][] dp;

    private static final int mod = (int) 1e9 + 7;
    public int knightDialer(int n) {
        int res = 0;
        dp = new Integer[n + 1][4][3];
        for(int i = 0; i < 4; i++) { // 4 rows
            for(int j = 0; j < 3; j++) { // 3 columns
                res = (res + (dfs(i, j, n) % mod)) % mod;
            }
        }

        return res % mod;
    }

    private int dfs(int i, int j, int n) {
        if (i < 0 || j < 0 || i >= 4 || j >= 3 || (i == 3 && j != 1))
            return 0;
        if (n == 1)
            return 1;
        if(dp[n][i][j] != null)
            return dp[n][i][j];

        int res = 0;

        for(int[] each : dirs) {
            int x = each[0] + i;
            int y = each[1] + j;

            res = (res + (dfs(x, y, n - 1) % mod)) % mod;

        }

        dp[n][i][j] = res % mod;
        return res % mod;
    }
}
