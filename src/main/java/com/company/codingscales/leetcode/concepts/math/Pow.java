package com.company.codingscales.leetcode.concepts.math;

// https://cp-algorithms.com/algebra/binary-exp.html
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

    public double myPowIterative(double a, long b) {
        double res = 1;
        while (b > 0) {
            if ((b & 1) == 1)
                res = res * a;
            a = a * a;
            b >>= 1;
        }
        return res;
    }
}
