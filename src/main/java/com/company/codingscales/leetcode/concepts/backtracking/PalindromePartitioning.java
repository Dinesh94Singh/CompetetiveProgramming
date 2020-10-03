package com.company.codingscales.leetcode.concepts.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Check the DP solution too. DP sol -> Find all the longest palindrome substrings which are palindromes
 * boolean[i][j] = true means, substring (i -> j + 1) => then its a pallindrome
 */
public class PalindromePartitioning {
    // "aab" => "aa", "b" => "a", "a", "b"
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

    static public List<List<String>> partition(String s) {
        final List<List<String>> res = new ArrayList<>();
        recHelper(s, new ArrayList<String>(), res);
        return res;
    }
}
