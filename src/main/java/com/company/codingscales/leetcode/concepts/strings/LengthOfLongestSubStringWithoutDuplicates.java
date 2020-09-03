package com.company.codingscales.leetcode.concepts.strings;

import java.util.HashMap;

public class LengthOfLongestSubStringWithoutDuplicates {
    public static int lengthOfLongestSubstring(final String s) {
        if (s.isEmpty()) {
            return 0;
        }
        // o(n) solution
        int start = 0, end = 0;
        final HashMap<Character, Integer> hm = new HashMap<>();
        int maxLength = Integer.MIN_VALUE;
        while (end < s.length() && start <= end) {
            final char ch = s.charAt(end);

            if (hm.containsKey(ch) && start < hm.get(ch) + 1) {
                start = hm.get(ch) + 1;
            }

            hm.put(ch, end);


            if (end - start + 1 > maxLength) {
                System.out.println(start + " " + end);
                maxLength = end - start + 1;
            }

            end++;
        }

        return maxLength != Integer.MIN_VALUE ? maxLength : 1;
    }

    public static void main(final String[] args) {
        System.out.println(lengthOfLongestSubstring("abba"));
    }

}
