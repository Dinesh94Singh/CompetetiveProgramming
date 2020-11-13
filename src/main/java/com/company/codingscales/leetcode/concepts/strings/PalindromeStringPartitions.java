package com.company.codingscales.leetcode.concepts.strings;

import java.util.ArrayList;
import java.util.List;

public class PalindromeStringPartitions {
    static int count = 0;
    private static boolean checkPalindrome(final String s) {
        if (s.isEmpty()) { return false; }
        int i = 0, j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) { return false; }
            i++;
            j--;
        }

        return true;
    }

    private static void recHelper(final String remainingStr, final List<String> list, final List<List<String>> res) {
        System.out.println(list);
        if (remainingStr.isEmpty()) { res.add(new ArrayList<>(list)); return; }

        for(int i = 0; i < remainingStr.length() + 1; i++) {
            final String substring = remainingStr.substring(0, i);
            if (checkPalindrome(substring)) {
                list.add(substring);
                recHelper(remainingStr.substring(i), list, res);
                list.remove(list.size() - 1);
            }
        }
    }

    public static List<List<String>> partition(final String s) {
        count = 0;
        final List<List<String>> res = new ArrayList<>();
        recHelper(s, new ArrayList<String>(), res);
        System.out.println("Size is " + count);
        return res;
    }


    public static void main(String[] args) {
        System.out.println(partition("aab"));
        System.out.println(partition("aaa"));
        System.out.println(partition("abc"));
    }
}
