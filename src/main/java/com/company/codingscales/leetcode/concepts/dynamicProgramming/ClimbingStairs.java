package com.company.codingscales.leetcode.concepts.dynamicProgramming;

import java.util.HashMap;

// Fibonacci series
public class ClimbingStairs {
    HashMap<Integer, Integer> dp = new HashMap<>();

    int recHelper(int n) {
        if (n == 0)
            return 1;
        if (n == 1 || n == 2)
            return n;

        if (dp.containsKey(n))
            return dp.get(n);
        int res = recHelper(n - 1) + recHelper(n - 2);
        dp.put(n, res);
        return res;

    }

    public int climbStairs(int n) {
        return recHelper(n);
    }

    public int climbStairsDP(int n) {
        if (n == 0 || n == 1)
            return n;

        int n1 = 0;
        int n2 = 1;

        int t = 0;
        for(int i = 0; i < n; i++) {
            t = n1 + n2;
            n1 = n2;
            n2 = t;
        }

        return t;
    }
}
