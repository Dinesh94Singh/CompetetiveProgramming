package com.company.codingscales.leetcode.concepts.dynamicProgramming.longestStrings;

/**
 * LongestRepeatingSubsequence & LongestDuplicateSubsequence are the same
 */
public class LongestRepeatingSubsequence {
    static Integer[][] dp;

    static int dfs(final int i, final int j, final String s) {
        if (i == s.length() || j == s.length())
            return 0;

        if (dp[i][j] != null)
            return dp[i][j];

        if (i != j && s.charAt(i) == s.charAt(j)) {
            dp[i][j] = 1 + dfs(i + 1, j + 1, s);
        } else {
            final int c1 = dfs(i, j + 1, s);
            final int c2 = dfs(i + 1, j, s);

            dp[i][j] = Math.max(c1, c2);
        }

        return dp[i][j];
    }

    static int LRS(String s) {
        dp = new Integer[s.length()][s.length()];
        return dfs(0, 0, s);
    }

    static int LRSBottomUp(String s) {
        dp = new Integer[s.length() + 1][s.length() + 1];
        int maxLength = 0;

        for(int i = 1; i <= s.length(); i++) {
            for(int j = 1; j <= s.length(); j++) {
                if (i != j && s.charAt(i) == s.charAt(j))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);

                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }

        return maxLength;
    }
}
