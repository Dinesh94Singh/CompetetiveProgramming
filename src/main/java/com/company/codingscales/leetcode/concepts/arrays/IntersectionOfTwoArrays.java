package com.company.codingscales.leetcode.concepts.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] A, int[] B) {
        int n1 = A.length;
        int n2 = B.length;

        List<Integer> res = new ArrayList<>();

        Arrays.sort(A);
        Arrays.sort(B);

        int i = 0, j = 0;

        while (i < n1 && j < n2) {
            if (A[i] == B[j]) {
                res.add(A[i]);

                while (i < n1 - 1 && A[i] == A[i + 1]) {
                    i++;
                }

                i++;

                while (j < n2 - 1 && B[j] == B[j + 1]) {
                    j++;
                }

                j++;
            } else if (A[i] < B[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] ans = new int[res.size()];

        int k = 0;
        for(int e : res)
            ans[k++] = e;

        return ans;
    }
}
