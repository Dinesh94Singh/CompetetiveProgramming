package com.company.codingscales.leetcode.concepts.dynamicProgramming.longestStrings;

import java.util.Arrays;

/**
 * Amazon interview question - 2019 interview for Ads team
 */
public class DistinctSubsequences {

    public int numDistinctMemo(String s, String t) {
        // easy dynamic programming problem we have seen a million times using DFS
        int[][] memo = new int[s.length()][t.length()]; // This will track how many ways the word can be completed from this point

        for (int[] arr : memo)
            Arrays.fill(arr, -1);

        // easy checks to save processing
        if (t.length() > s.length())
            return 0;

        if (t.length() == s.length() && t.equals(s))
            return 1;
        else if (t.length() == s.length())
            return 0;

        return dfs(s, t, 0, 0, memo);
    }

    public int dfs(String s, String t, int i, int j, int[][] memo) {

        // found a match
        if (j == t.length())
            return 1;
        else if (s.length() == i) // hit the end without a match
            return 0;

        // already calculated this position
        if (memo[i][j] != -1)
            return memo[i][j];

        int cases = 0;

        // advance both characters if they match OR only the bigger strings
        if (s.charAt(i) == t.charAt(j))
            cases = dfs(s, t, i + 1, j + 1, memo) + dfs(s, t, i + 1, j, memo);
        else
            cases = dfs(s, t, i + 1, j, memo);

        memo[i][j] = cases;
        return cases;
    }

    public int numDistinct(String a, String b) {
        // count the number of ways
        int n1 = a.length();
        int n2 = b.length();

        int[][] dp = new int[n1 + 1][n2 + 1];

        for(int i = 0; i < a.length(); i++) { // when you reach end, there should be valid
            dp[i][0] = 1;
        }

        for(int i = 1; i <= n1; i++) {
            for(int j = 1; j <= n2; j++) {
                dp[i][j] = dp[i - 1][j];
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }

        return dp[a.length()][b.length()];
    }
}
