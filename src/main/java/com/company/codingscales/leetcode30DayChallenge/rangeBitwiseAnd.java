package com.company.codingscales.leetcode30DayChallenge;

public class rangeBitwiseAnd {
    public static int rangeBitwiseAnd(final int i, int j) {
        while (i < j) {
            j = j & (j - 1);
        }
        return i & j;
    }

    public static void main(final String[] args) {
        System.out.println(rangeBitwiseAnd(5, 7));
    }
}
