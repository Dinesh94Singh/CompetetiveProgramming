package com.company.codingscales.leetcode.concepts.arrays;

public class CountPrimes {
    public int countPrimes(int n) {
        if (n <= 2)
            return 0;

        int[] A = new int[n];

        // i = 2, 3, 5, 7, 11
        for(int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (A[i] == 0) {
                for(int j = i * i; j < n; j += i) { // multiples of i => 2, 4, 8, ...
                    A[j]++;
                }
            }
        }

        int count = 0;

        for(int i = 2; i < n; i++)
            if (A[i] == 0)
                count++;

        return count;
    }
}
