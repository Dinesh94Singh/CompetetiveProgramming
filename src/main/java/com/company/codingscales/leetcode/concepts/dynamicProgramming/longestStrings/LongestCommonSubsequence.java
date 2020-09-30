package com.company.codingscales.leetcode.concepts.dynamicProgramming.longestStrings;

public class LongestCommonSubsequence {
    static int dp[][];

    static int dfs(int i, int j, String s1, String s2) {
        if (s1.length() == i || s2.length() == j)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (s1.charAt(i) == s2.charAt(j))
            dp[i][j] = 1 + dfs(i + 1, j + 1, s1, s2);
        else {
            dp[i][j] = 1 + Math.max(dfs(i + 1, j, s1, s2), dfs(i, j + 1, s1, s2));
        }
        return dp[i][j];
    }

    static int lcsLength(String s1, String s2) {
        final int length = Math.min(s1.length(), s2.length());
        dp = new int[s1.length()][s2.length()];
        for(int i = 0; i < s1.length(); i++) {
            for(int j = 0; j < s2.length(); j++)
                dp[i][j] = -1;
        }

        return dfs(0, 0, s1, s2);
    }

    static int lcsLengthBottomUp(String s1, String s2) {
        final int[][] dp = new int[s1.length()][s2.length()];
        int maxLength = Integer.MIN_VALUE;
        for(int i = 1; i < s1.length(); i++) {
            for(int j = 1; j < s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }

        return maxLength;
    }
}
