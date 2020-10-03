package com.company.codingscales.leetcode.concepts.dynamicProgramming;

public class RegularExpressionMatching {
    Boolean[][] dp;

    boolean dfs(int sIndex, int pIndex, String s, String p) {
        if (pIndex == p.length())
            return sIndex == s.length();

        if (sIndex < s.length() && dp[sIndex][pIndex] != null)
            return dp[sIndex][pIndex];

        boolean isMatch = false;
        boolean ret = false;

        if (sIndex != s.length())
            isMatch = s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '.';
        if (pIndex < p.length() - 1 && p.charAt(pIndex + 1) == '*') {
            ret |= dfs(sIndex, pIndex + 2, s, p);
            ret |= (isMatch && dfs(sIndex + 1, pIndex, s, p));
        } else if (isMatch) {
            ret |= dfs(sIndex + 1, pIndex + 1, s, p);
        }

        if (sIndex < s.length())
            dp[sIndex][pIndex] = ret;

        return ret;
    }

    public boolean isMatch(final String s, final String p) {
        dp = new Boolean[s.length()][p.length()];
        return dfs(0, 0, s, p);
    }

    public boolean isMatchBottomUp(String text, String pattern) { // TODO: learn this. Can we do this, from (0, 0) instead of (s.length(), p.length())
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;

        for (int i = text.length(); i >= 0; i--){
            for (int j = pattern.length() - 1; j >= 0; j--){
                boolean first_match = (i < text.length() &&
                        (pattern.charAt(j) == text.charAt(i) ||
                                pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                    dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
                } else {
                    dp[i][j] = first_match && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }
}
