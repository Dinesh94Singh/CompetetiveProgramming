package com.company.codingscales.binarysearchio.concepts.math;

public class FactorialFirst {
    public int solve(int n) {
        if (n == 0 || n == 1)
            return 1;

        return n * solve(n - 1);
    }

    public int solveIterative(int n) {
        int res = 1;

        for (int i = 1; i <= n; i++) {
            res *= i;
        }

        return res;
    }
}
