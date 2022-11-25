package com.company.codingscales.leetcode.concepts.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfThreeSortedArrays {
    public List<Integer> arraysIntersection(int[] A, int[] B, int[] C) {
        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);

        int i = 0, j = 0, k = 0;
        List<Integer> res = new ArrayList<>();

        while (i < A.length && j < B.length && k < C.length) {
            if (A[i] == B[j] && B[j] == C[k]) {
                res.add(A[i]);
                i++;
                j++;
                k++;
            } else {
                if (A[i] < B[j] && A[i] < C[k]) {
                    i++;
                } else if (B[j] < C[k]) {
                    j++;
                } else {
                    k++;
                }
            }
        }

        return res;
    }
}
