package com.company.codingscales.interviews.microsoft;

public class LongestSubstringWithout3ConsequitiveOccurencesOfLetter {
    private static String solve(final String s) {
        if (s == null || s.isEmpty())
            return "";
        if (s.length() < 3)
            return s;

        char ch = s.charAt(0);
        int count = 1;
        int start = 0, end = 1;
        int subStringStart = 0, subStringEnd = 0;
        int maxLength = Integer.MIN_VALUE;

        while (end < s.length()) {
            if (s.charAt(end) == ch) {
                count ++;
                if (count == 2) {
                    // it means, we encountered 2 consequitive occurences of the same letter
                    // check if this could be the largest substring
                    if (maxLength < end - start + 1) {
                        maxLength = end - start + 1;
                        subStringStart = start;
                        subStringEnd = end + 1; // exclusive in substring function
                    }
                } else {
                    start = end - 1;
                }
            } else {
                ch = s.charAt(end);
                count = 1;
                if (maxLength < end - start + 1) {
                    maxLength = end - start + 1;
                    subStringStart = start;
                    subStringEnd = end + 1;
                }
            }

            end++;
        }

        return s.substring(subStringStart, subStringEnd);
    }

    public static void main(final String[] args) {
        System.out.println(solve("aabbaaaaabb"));
        System.out.println(solve("aabbaabbaabbaa"));
        System.out.println(solve("aaa"));
        System.out.println(solve("aaabaaa"));
        System.out.println(solve("baaabbabbb"));
        System.out.println(solve("babba"));
    }
}
