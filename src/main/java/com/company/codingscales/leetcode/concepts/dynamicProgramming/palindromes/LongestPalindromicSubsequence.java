package com.company.codingscales.leetcode.concepts.dynamicProgramming.palindromes;

public class LongestPalindromicSubsequence {
    static Integer[][] dp;
    static int dfs(int start, int end, String s) {
        if (start == end) {
            return 1;
        }

        if (start > end) {
            return 0;
        }

        if (dp[start][end] != null)
            return dp[start][end];

        int maximum = Integer.MIN_VALUE;
        if (s.charAt(start) == s.charAt(end)) {
            maximum = Math.max(maximum, dfs(start + 1, end - 1, s));
        }

        maximum = Math.max(maximum, dfs(start + 1, end, s));
        maximum = Math.max(maximum, dfs(start, end - 1, s));

        dp[start][end] = maximum;
        return maximum;
    }

    static int lps(String s) {
        dp = new Integer[s.length()][s.length()];
        return dfs(0, s.length() - 1, s);
    }

    static int lpsBottomUp(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int i = 0; i < s.length() - 1; i++) {
            dp[i][i] = 1;
        }

        for(int i = s.length() - 1; i >= 0; i--) {
            for(int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][s.length() - 1];
    }
}
