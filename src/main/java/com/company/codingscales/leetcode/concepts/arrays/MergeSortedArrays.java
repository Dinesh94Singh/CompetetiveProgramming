package com.company.codingscales.leetcode.concepts.arrays;

class Solution {
    public void merge(int[] A, int m, int[] B, int n) {
        int i = m - 1; // 2
        int j = n - 1; // 2

        int k = m + n - 1; // 5

        while (j >= 0) {
            if (i < 0 || A[i] <= B[j]) {
                A[k] = B[j];
                j--;
            } else {
                A[k] = A[i];
                i--;
            }

            k -= 1;
        }
    }
}
