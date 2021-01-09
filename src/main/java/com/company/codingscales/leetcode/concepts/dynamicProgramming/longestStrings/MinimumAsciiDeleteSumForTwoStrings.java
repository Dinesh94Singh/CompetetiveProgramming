package com.company.codingscales.leetcode.concepts.dynamicProgramming.longestStrings;

public class MinimumAsciiDeleteSumForTwoStrings {
    public int minimumDeleteSum(String s1, String s2) {
        final int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for(int i = 1; i <= s1.length(); i++)
            dp[i][0] = s1.charAt(i - 1);

        for(int i = 1; i <= s2.length(); i++)
            dp[0][i] = s2.charAt(i - 1);

        for(int i = 1; i <= s1.length(); i++) {
            for(int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                }
            }
        }
    }
}
