package com.company.codingscales.leetcode.concepts.strings;

import java.util.Arrays;
import java.util.List;

public class LongestWordInDictionaryThroughDeleting {
    private static boolean isSubsequence(String t1, String t2) {
        int i = 0, j = 0;

        while (i < t2.length() && j < t1.length()) {
            if (t1.charAt(j) == t2.charAt(i))
                j++;
            i++;
        }

        return j == t1.length();
    }

    public static String findLongestWord(String s, List<String> d) {
        d.sort((e1, e2) -> e2.length() == e1.length() ? e1.compareTo(e2) : e2.length() - e1.length());

        for(String each : d) {
            if (isSubsequence(each, s)) {
                return each;
            }
        }

        return "";
    }

    public static void main(String[] args) {
        findLongestWord("abpcplea", Arrays.asList("ale", "apple", "monkey", "plea"));
    }
}
