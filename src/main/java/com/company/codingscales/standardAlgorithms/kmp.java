package com.company.codingscales.standardAlgorithms;

import java.util.ArrayList;

public class kmp {
    /**
     * LPS of 0 is always 0
     * 3 Cases
     *      case1 s[len] == s[i] then lps[i] = lps[i-1] + 1
     *      case2.1: s[len] != s[i] && len == 0: lps[i] = 0
     *      case2.2: s[len] != s[i] && len > 0: len = lps[i-1]
     */
    private static void compute_lps(final String pattern, final int[] lps) {
        // lps[0] is always 0
        for(int i = 1; i < pattern.length(); i++) {
            int prev = lps[i - 1];
            while (prev > 0 && pattern.charAt(i) != pattern.charAt(prev)) {
                prev = lps[prev - 1];
            }

            if (pattern.charAt(i) == pattern.charAt(prev))
                lps[i] = prev + 1;
        }

        /**
         *     private void compute_lps(final String pattern, final int[] lps) {
         *         // lps[0] is always 0
         *         int i = 1;
         *         int len = 0;
         *         while (i < pattern.length()) {
         *             if (pattern.charAt(i) == pattern.charAt(len)) {
         *                 lps[i] = lps[i - 1] + 1; // equivallent to len + 1
         *                 len++;
         *                 i++;
         *             }
         *             else { // don't match
         *                 if (len == 0) {
         *                     lps[i] = 0;
         *                     i++;
         *                 } else {
         *                     len = lps[len - 1];
         *                 }
         *             }
         *         }
         *     }
         */
    }

    /**
     * 3 cases ->
     * case 1: s[i] == p[j] -> i += 1; j += 1;
     * if j == pattern.length() -> add into result
     * case 2.1 => s[i] != s[j] && j == 0: i += 1;
     * case 2.2 => s[i] != s[j] && j > 0: j = lps[j-1];
     */
    private static ArrayList<Integer> kmp(final String s, final String pattern) {
        final int[] lps = new int[pattern.length()];
        int i = 0, j = 0;
        final ArrayList<Integer> res = new ArrayList<>();

        compute_lps(pattern, lps);
        while(i < s.length()) {
            if (pattern.charAt(j) == s.charAt(i)) {
                i += 1; j += 1;
            }

            if (j == pattern.length()) {
                res.add(i - j);
                j = lps[j - 1];
            }
            else if (i < s.length() && pattern.charAt(j) != s.charAt(i)) {
                if (j == 0) {
                    i += 1;
                } else {
                    j = lps[j - 1];
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
//        for(Integer each: kmp("aabaabaa", "aa")) {
//            System.out.println(each);
//        }

//        for(Integer each: kmp("aacecaaa#aaacecaa", "aacecaaa#aaacecaa")) {
//            System.out.println(each);
//        }

        for(Integer each: kmp("aacecaaa#aaacecaa", "aabaaa#aaabaa")) {
            System.out.println(each);
        }
    }
}
