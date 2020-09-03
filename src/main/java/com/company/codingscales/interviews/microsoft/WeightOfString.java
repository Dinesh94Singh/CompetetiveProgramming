package com.company.codingscales.interviews.microsoft;

public class WeightOfString {
    public static void main(final String[] args) {
        final String s1 = "hellomrz";
        final String s2 = "aaaaa";
        final int n1 = 2;
        final int n2 = 1;
        System.out.println(solve(s1, n1));
        System.out.println(solve(s2, n2));
    }

    private static int solve(final String s, final int n) {
        int res = 0;
        for(final char c : s.toCharArray())
            res += ((c - 'a') + n) % 26;
        return res;
    }
}
