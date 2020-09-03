package com.company.codingscales.interviews.microsoft;

public class MaxNumberOfInsertsIntoString {
    private static int solve(final String s) {
        int count = 0;
        final char ch = 'a';
        int res = 0;
        int end = 0;

        while (end < s.length()) {
            if (ch == s.charAt(end)) {
                count++;
            } else {
                res += 2 - count;
                count = 0;
            }

            if (count == 3) {
                return -1;
            }
            end++;
        }
        if (s.charAt(s.length() - 1) == ch)
            res += 2 - count;
        else
            res += 2 - count;
        return res;
    }
    public static void main(final String[] args) {
        System.out.println(solve("aa")); // 0
        System.out.println(solve("aaa")); // -1
        System.out.println(solve("baabba"));  // 5
        System.out.println(solve("aabab")); // 3
        System.out.println(solve("dog")); // 8
        System.out.println(solve("aaba")); // 1
    }
}
