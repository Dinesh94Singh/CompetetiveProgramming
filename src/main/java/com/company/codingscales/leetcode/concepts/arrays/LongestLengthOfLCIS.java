package com.company.codingscales.leetcode.concepts.arrays;

public class LongestLengthOfLCIS {
    public int findLengthOfLCIS(int[] A) {
        // sliding window?

        if (A.length == 0 || A.length == 1)
            return A.length;

        int i = 0, j = 1;
        int res = Integer.MIN_VALUE;
        while (j < A.length) {
            if (A[j] > A[j - 1]) {
                j++;
            } else {
                res = Math.max(res, j - i);

                i = j;
                j++;
            }
        }

        res = Math.max(res, j - i);

        return res;
    }
}
