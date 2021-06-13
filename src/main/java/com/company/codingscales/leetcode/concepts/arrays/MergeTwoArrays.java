package com.company.codingscales.leetcode.concepts.arrays;

import com.company.codingscales.templates.LeetCodeInputHelpers;

public class MergeTwoArrays {
    public static void merge(final int[] A, final int m, final int[] B, final int n) {
        int i = m - 1;
        int j = B.length - 1;

        int k = A.length - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] < B[j]) {
                A[k] = B[j];
                j--;
            } else {
                A[k] = A[i];
                i--;
            }

            k--;
        }

        while (j >= 0) {
            A[k] = B[j];
            k--;
            j--;
        }
    }

    public static void main(final String[] args) {
        merge(LeetCodeInputHelpers.stringToIntArray("[4,5,6,0,0,0]"), 3, LeetCodeInputHelpers.stringToIntArray("[1,2,3]"), 3);
    }
}
