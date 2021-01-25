package com.company.codingscales.leetcode.concepts.greedy;

public class PreviousPermutationWith1Swap {
    private void swap(int[] A, int i, int j) {
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }

    public int[] prevPermOpt1(int[] A) {
        int n = A.length;

        int k = -1;
        for(int i = n - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                k = i;
                break;
            }
        }

        if (k == -1)
            return A;

        // Starting from k+1 find largest A[l], which is less than A[k]
        int l = k + 1;
        int max = A[l];
        for(int i = k + 2; i < n; i++) {
            if (A[i] > max && A[i] < A[k]) {
                l = i;
                max = A[l];
            }
        }

        swap(A, l, k);
        return A;
    }
}
