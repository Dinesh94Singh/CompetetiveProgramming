package com.company.codingscales.leetcode.concepts.math;

public class ReverseInteger {
    public int reverse(long x) {
        long n = 0;

        boolean isNegative = x < 0;

        x = Math.abs(x);

        while (x != 0) {
            if (n * 10 >= Integer.MAX_VALUE)
                return 0;

            n = n*10 + (x % 10);
            x = x / 10;
        }

        return isNegative ? -(int) n : (int) n;
    }
}
