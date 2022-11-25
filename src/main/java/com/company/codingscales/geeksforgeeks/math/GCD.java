package com.company.codingscales.geeksforgeeks.math;

public class GCD {
    static int gcd(int a, int b) {
        if (a == 0 || b == 0)
            return a + b;

        return gcd(b, a % b);
    }

    static int gcdIterative(int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }

        return a;
    }
}
