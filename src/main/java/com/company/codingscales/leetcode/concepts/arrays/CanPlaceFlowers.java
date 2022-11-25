package com.company.codingscales.leetcode.concepts.arrays;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] A, int n) {
        if (n > A.length)
            return false;


        int i = 0;

        while (i < A.length && n > 0) {
            if (A[i] == 0 && (i == 0 || A[i - 1] != 1) && (i == A.length - 1 || A[i + 1] != 1)) {
                A[i] = 1;
                n--;
            }

            i++;

        }

        if (n == 0)
            return true;
        return false;
    }
}
