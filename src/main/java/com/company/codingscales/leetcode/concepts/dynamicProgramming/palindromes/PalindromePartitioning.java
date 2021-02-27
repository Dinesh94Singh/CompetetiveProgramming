package com.company.codingscales.leetcode.concepts.dynamicProgramming.palindromes;

import java.util.*;

public class PalindromePartitioning {
    static boolean checkPalindrome(String s) {
        if (s.isEmpty())
            return false;
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    static void recHelper(final String s, final List<String> list, final List<List<String>> res) {
        if (s.isEmpty()) {
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < s.length() + 1; i++) {
            final String substr = s.substring(0, i);
            if (checkPalindrome(substr)) {
                list.add(substr);
                recHelper(s.substring(i), list, res);
                list.remove(list.size() - 1);
            }
        }
    }

    static public List<List<String>> partitionWithBackTracking(String s) {
        final List<List<String>> res = new ArrayList<>();
        recHelper(s, new ArrayList<String>(), res);
        return res;
    }

    public List<List<String>> partitionWithDP(String s) {
        int N = s.length();
        boolean[][] dp = new boolean[N][N];
        List<List<String>> res = new  ArrayList<>();
        dfs(res, s, 0, new ArrayList<>(), dp);
        return res;
    }

    private void dfs(List<List<String>> res, String s, int i, List<String> currList, boolean[][] dp) {
        if (i >= s.length()) {
            res.add(new ArrayList<>(currList));
            return;
        }
        for(int j = i; j < s.length(); j++) {
            if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i+1][j - 1])) {
                dp[i][j] = true;
                currList.add(s.substring(i, j+1));
                dfs(res, s, j + 1, currList, dp);
                currList.remove(currList.size() - 1);
            }

        }
    }
}
