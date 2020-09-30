package com.company.codingscales.leetcode.concepts.dynamicProgramming.longestStrings;

public class MinimumDeletionsAndInsertionsToFormAnotherString {
    int minDeletionsAndInsertions(String s1, String s2) {
        return s1.length() - LongestCommonSubsequence.lcsLengthBottomUp(s1, s2);
    }
}
