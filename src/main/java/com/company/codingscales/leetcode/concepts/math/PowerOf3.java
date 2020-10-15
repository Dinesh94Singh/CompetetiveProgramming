package com.company.codingscales.leetcode.concepts.math;

public class PowerOf3 {
    boolean dfs(int n) {
        if (n == 0)
            return false;

        while (n % 3 == 0) {
            n = n / 3;
        }

        return n == 1;
    }

    public boolean isPowerOfThree(int n) {
        return dfs(n);
    }

    public boolean isPowerOfThreeUsingMath(int n) {
        // 3^x = n
        // xlog3 = logn
        // x = logn/log3

        // if x % 1 == 0
        // In Java, we check if a number is an integer by taking the decimal part (using % 1) and checking if it is 0. If decimal, then not a power of 3
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }
}
