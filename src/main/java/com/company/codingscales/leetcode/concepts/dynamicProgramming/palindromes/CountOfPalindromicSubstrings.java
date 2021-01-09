package com.company.codingscales.leetcode.concepts.dynamicProgramming.palindromes;

public class CountOfPalindromicSubstrings {
    int findCPS(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int count = 0;

        for(int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            count++;
        }

        for(int i = s.length() - 1; i >= 0; i--) {
            for(int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i == 1 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        count++;
                    }
                }
            }
        }

        return count;
    }

    int count = 0;

    public int countSubstrings(String s) {
        if (s == null || s.isEmpty())
            return 0;

        for (int i = 0; i < s.length(); i++) { // i is the mid point
            extendPalindrome(s, i, i); // odd length;
            extendPalindrome(s, i, i + 1); // even length
        }

        return count;
    }

    private void extendPalindrome(String s, int left, int right) {
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++; left--; right++;
        }
    }

    int findCPSUsingExpandAroundCenter(String s) {
        return countSubstrings(s);
    }
}
