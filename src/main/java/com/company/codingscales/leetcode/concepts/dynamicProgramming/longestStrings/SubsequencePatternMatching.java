package com.company.codingscales.leetcode.concepts.dynamicProgramming.longestStrings;

public class SubsequencePatternMatching {
    static int[][] dp;

    static int dfs(int i, int j, String s, String p) {
        if (j == p.length())
            return 1;

        if (i == s.length())
            return 0;

        int c1 = 0;
        if (s.charAt(i) == p.charAt(j))
            c1 = dfs(i + 1, j + 1, s, p);

        int c2 = dfs(i + 1, j, s, p);

        dp[i][j] = c1 + c2;
        return dp[i][j];
    }

    static int patternMatching(String s, String p) {
        return dfs(0, 0, s, p);
    }

    static int patternMatchingBottomUp(String s, String p) {
        dp = new int[s.length() + 1][p.length() + 1];
        for(int i = 1; i < s.length(); i++) {
            for(int j = 1; j < p.length(); j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];

                dp[i][j] += dp[i - 1][j];
            }
        }

        return dp[s.length()][p.length()];
    }
}
