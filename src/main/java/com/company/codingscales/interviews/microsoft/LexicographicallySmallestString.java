package com.company.codingscales.interviews.microsoft;

public class LexicographicallySmallestString {
    private static String solve(final String s) {
        if (s == null || s.isEmpty())
            return null;
        if (s.length() == 1)
            return s;

        for (int i = 0; i < s.length() - 1; i++) {
            if ( s.charAt(i) >  s.charAt(i + 1)) {
                return s.substring(0, i).concat(s.substring(i + 1));
            }
        }

        return null;
    }
    public static void main(final String[] args) {
        System.out.println(solve("abczd"));
    }
}
