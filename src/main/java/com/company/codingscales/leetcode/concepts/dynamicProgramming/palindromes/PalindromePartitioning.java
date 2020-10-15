package com.company.codingscales.leetcode.concepts.dynamicProgramming.palindromes;

public class PalindromePartitioning {
    // total number of partitions  = Total no of palindromic substring - 1
    int palindromePartitioning(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        String res = "";

        for(int i = s.length() - 1; i >= 0; i--) {
            for(int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i == 1 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    }
                }
            }
        }

        // we now have the all indexes where palindrome can be formed.
        // if palindrome is formed because of the end => Then min cuts = 0;
        // if palindrome is formed because of the starting => Then min cuts = 0;
        // else there are 1 cuts at-least;

        int[] cuts = new int[s.length()];
        for(int i = s.length() - 1; i >= 0; i--) {
            int minCuts = s.length();
            for(int j = s.length() - 1; j >= i; j--) {
                if (j == s.length() - 1) {
                    minCuts = 0;
                } else {
                    minCuts = Math.min(minCuts, 1 + cuts[j + 1]);
                }
            }
            cuts[i] = minCuts;
        }
        return cuts[0];
    }
}
