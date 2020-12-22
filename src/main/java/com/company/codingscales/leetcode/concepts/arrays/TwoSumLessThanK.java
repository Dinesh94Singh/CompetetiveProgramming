package com.company.codingscales.leetcode.concepts.arrays;

import java.util.Arrays;

public class TwoSumLessThanK {
    public int twosumLessThanKTwoPointers(int [] A, int k) {
        int N = A.length;
        int i = 0, j = N - 1;

        Arrays.sort(A);
        int s = -1;

        while (i < j) {
            if (A[i] + A[j] < k) {
                s = Math.max(s, A[i] + A[j]);
                i++;
            } else {
                j--;
            }
        }

        return s;
    }
}
