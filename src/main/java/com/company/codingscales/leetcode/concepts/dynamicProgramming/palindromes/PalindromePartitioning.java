package com.company.codingscales.leetcode.concepts.dynamicProgramming.palindromes;

public class PalindromePartitioning {
    static int palindromePartitioning(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
		
        int[] res = new int[s.length()];

        for(int i = s.length() - 1; i >= 0; i--) {
            for(int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i == 1 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    }
                }
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (dp[0][i])
                res[i] = 0;
            else {
                res[i] = Integer.MAX_VALUE;
                for (int j = 0; j < i; j++) {
                    if (dp[j+1][i] && res[i] > 1 + res[j])
                        res[i] = 1+res[j];
                }
            }
        }

        return res[s.length() - 1] == Integer.MAX_VALUE ? 1 : res[s.length() - 1];
    }

    public static void main(String[] args) {
        System.out.println(palindromePartitioning("aab"));
    }
}
