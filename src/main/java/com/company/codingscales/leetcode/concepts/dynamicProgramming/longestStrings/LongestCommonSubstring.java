package com.company.codingscales.leetcode.concepts.dynamicProgramming.longestStrings;

public class LongestCommonSubstring {
    static int dp[][][];

    static int dfs(int i, int j, String s1, String s2, int count) {
        if (s1.length() == i || s2.length() == j)
            return count;

        if (dp[i][j][count] != -1)
            return dp[i][j][count];

        if (s1.charAt(i) == s2.charAt(j))
            dp[i][j][count] = dfs(i + 1, j + 1, s1, s2, count + 1);
        dp[i][j][count] = Math.max(dp[i][j][count], Math.max(dfs(i + 1, j, s1, s2, 0), dfs(i, j + 1, s1, s2, 0)));
        return dp[i][j][count];
    }

    static int lcsLength(String s1, String s2) {
        final int length = Math.min(s1.length(), s2.length());
        dp = new int[s1.length()][s2.length()][length];
        for(int i = 0; i < s1.length(); i++) {
            for(int j = 0; j < s2.length(); j++)
                for(int k = 0; k < length; k++)
                    dp[i][j][k] = -1;
        }

        return dfs(0, 0, s1, s2, 0);
    }

    static int lcsLengthBottomUp(String s1, String s2) {
        final int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int maxLength = 0;

        for(int i = 1; i <= s1.length(); i++) {
            for(int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
            }
        }

        return maxLength;
    }
}
