package com.company.codingscales.leetcode.concepts.dynamicProgramming.palindromes;

public class MinimumDeletionsOfAStringToMakeItPalindrome {
    int minDeletions(String s) {
        return s.length() - LongestPalindromicSubsequence.lpsBottomUp(s);
    }
}
