package com.company.codingscales.leetcode.concepts.miscellaneous;

public class Pow {
    public double myPow(double x, long n) {
        if (n < 0) {
            return myPow(1 / x, -n);
        }

        if (n == 0)
            return 1;

        double half = myPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        }
        return half * half * x;
    }
}
