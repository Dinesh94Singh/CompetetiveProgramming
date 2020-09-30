package com.company.codingscales.leetcode.concepts.dynamicProgramming.longestStrings;

public class ShortestCommonSuperSequence {
    static int[][] dp;

    static int dfs(int i, int j, String s1, String s2) {
        if (i == s1.length())
            return s2.length() - j;
        if (j == s2.length())
            return s1.length() - i;

        if (s1.charAt(i) == s2.charAt(j)) {
            return 1 + dfs(i + 1, j + 1, s1, s2);
        }

        int c1 = 1 + dfs(i, j + 1, s1, s2);
        int c2 = 1 + dfs(i + 1, j, s1, s2);

        dp[i][j] = Math.min(c1, c2);
        return dp[i][j];
    }

    static int SCS(String s1, String s2) {
        return dfs(0, 0, s1, s2);
    }
}
