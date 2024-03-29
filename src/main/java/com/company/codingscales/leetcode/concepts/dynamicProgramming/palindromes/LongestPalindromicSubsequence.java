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
        int n = s.length();
        dp = new Integer[n][n];
        return dfs(0, n - 1, s);
    }

    static int lpsBottomUp(String s) {
        int n = s.length();
        if (s.isEmpty())
            return 0;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n - 1; i++) {
            dp[i][i] = 1;
        }

        int ans = 1;
        for(int i = n - 1; i >= 0; i--) {
            for(int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return ans;
        // return dp[0][n - 1];
    }
}
