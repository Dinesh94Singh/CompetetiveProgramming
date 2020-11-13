package com.company.codingscales.leetcode.concepts.strings;

import java.util.HashSet;

public class LongestSubStringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0;
        HashSet<Character> hs = new HashSet<>();
        int max = Integer.MIN_VALUE;
        while (j < s.length()) {
            char ch = s.charAt(j);
            if (hs.contains(ch)) {
                max = Math.max(max, j - i);
                while (i < j) {
                    char c = s.charAt(i);
                    if (ch == c) {
                        i++;
                        break;
                    }
                    hs.remove(c);
                    i++;
                }
            } else {
                hs.add(ch);
            }
            j++;
        }

        max = Math.max(max, j - i);

        if (max == Integer.MIN_VALUE)
            return 0;
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // abc - 3
        System.out.println(lengthOfLongestSubstring("bbbbb")); // b - 1
        System.out.println(lengthOfLongestSubstring("pwwkew")); // wke - 3
        System.out.println(lengthOfLongestSubstring("")); //
    }
}
