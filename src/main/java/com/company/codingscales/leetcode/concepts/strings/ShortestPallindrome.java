package com.company.codingscales.leetcode.concepts.strings;

public class ShortestPallindrome { // you can add characters in the front of the string
    static class KMP {
        int[] lps;

        void computeLps(String pattern) {
            int i = 1, len = 0;
            int N = pattern.length();

            while (i < N) {
                if (pattern.charAt(i) == pattern.charAt(len)) {
                    lps[i] = lps[i - 1] + 1;
                    i++;
                    len++;
                } else {
                    if (len == 0) {
                        lps[i] = 0;
                        i++;
                    } else {
                        len = lps[i - 1];
                    }
                }
            }
        }

        void kmp(String s, String p) {
            lps = new int[p.length()];
            computeLps(p);

            int i = 0, j = 0;
            while (i < s.length()) {
                if (s.charAt(i) == p.charAt(j)) {
                    i++;
                    j++;
                }

                if (j == p.length()) {
                    // Pattern found add j - N to res
                    j = lps[j - 1];
                } else if (i < s.length() && s.charAt(i) != p.charAt(j)) {
                    if (j == 0) {
                        i++;
                    } else {
                        j = lps[j - 1];
                    }
                }
            }
        }
    }

    public String shortestPalindrome(final String s) {
        KMP kmp = new KMP();
        String pattern = s + "#" + new StringBuilder(s).reverse().toString();
        kmp.computeLps(pattern);

        return new StringBuilder(s.substring(kmp.lps[kmp.lps.length - 1])).reverse().toString() + s;
    }

    public static void main(String[] args) {
        ShortestPallindrome pallindrome = new ShortestPallindrome();
        System.out.println(pallindrome.shortestPalindrome("aacecaaa"));
        System.out.println(pallindrome.shortestPalindrome("abcd"));
    }
}
