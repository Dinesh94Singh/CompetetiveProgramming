package com.company.codingscales.leetcode.concepts.strings;

import java.util.HashSet;

public class LongestSubStringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> hm = new HashSet<>();
        int start = 0, end = 0;
        int res = 0;
        while (end < s.length()) {
            char ch = s.charAt(end);
            if (hm.contains(ch)) {
                int dist = end - start;
                res = Math.max(res, dist);
                while (s.charAt(start) != ch) {
                    hm.remove(s.charAt(start));
                    start++;
                }
                start++;
            } else {
                hm.add(ch);
            }
            end++;
        }

        int dist = end - start;
        res = Math.max(res, dist);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // abc - 3
        System.out.println(lengthOfLongestSubstring("bbbbb")); // b - 1
        System.out.println(lengthOfLongestSubstring("pwwkew")); // wke - 3
        System.out.println(lengthOfLongestSubstring("")); //
    }
}
