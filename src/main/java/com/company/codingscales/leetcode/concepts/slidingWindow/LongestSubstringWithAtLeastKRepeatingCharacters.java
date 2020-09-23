package com.company.codingscales.leetcode.concepts.slidingWindow;

public class LongestSubstringWithAtLeastKRepeatingCharacters {
    private static int dc(final int start, final int end, final String s, final int k) {
        final int[] map = new int[26];
        for(int i = start; i < end; i++) {
            final char ch = s.charAt(i);
            map[ch - 97]++;
        }

        for(int i = start; i < end; i++) {
            int count = map[s.charAt(i) - 97];
            if (count != 0 && count < k) { // find the first occurrence, where it doesn't satisfy. Because of this, it is breaking, so either consider, left side or right side.
                final int left = dc(start, i, s, k);
                final int right = dc(i + 1, end, s, k);
                return Math.max(left, right);
            }
        }

        return end - start; // every char satisfies, so, we can return the substring length
    }

    private static int divideAndConquer(final String s, final int k) {
        return dc(0, s.length() - 1, s, k);
    }

    public static int longestSubstring(final String s, final int k) {
        // brute force solution is to create substring of different length => for(i: 0 -> n) { for(j : i -> n) { // check the substring j till n and see if its valid } }
        return divideAndConquer(s, k);
    }

    public static void main(String[] args) {
        System.out.println(longestSubstring("aaabb", 3));
    }
}
