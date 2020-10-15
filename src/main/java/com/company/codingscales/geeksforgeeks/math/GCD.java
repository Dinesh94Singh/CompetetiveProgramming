package com.company.codingscales.geeksforgeeks.math;

public class GCD {
    static int gcd(int a, int b) {
        if (a == 0 || b == 0)
            return a + b;

        return gcd(b, a % b);
    }
}
