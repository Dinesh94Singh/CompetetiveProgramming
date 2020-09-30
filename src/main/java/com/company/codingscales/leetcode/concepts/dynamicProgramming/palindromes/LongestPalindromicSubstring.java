package com.company.codingscales.leetcode.concepts.dynamicProgramming.palindromes;

public class LongestPalindromicSubstring {
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

        if (s.charAt(start) == s.charAt(end)) {
            int remaining = dfs(start + 1, end - 1, s);
            if (remaining == end - start - 1) {
                return end - start + 1;
            }
        }

        int maximum = Integer.MIN_VALUE;
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
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        String res = "";

        int maxLength = Integer.MIN_VALUE;
        for(int i = s.length() - 1; i >= 0; i--) {
            for(int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i == 1 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        if (maxLength < j - i + 1) {
                            maxLength = j - i + 1;
                            res = s.substring(i, j + 1);
                        }
                    }
                }
            }
        }

        System.out.println(res);
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lps("abdbca"));
        System.out.println(lpsBottomUp("abdbca"));
    }
}
