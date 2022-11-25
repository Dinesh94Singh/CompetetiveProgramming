package com.company.codingscales.leetcode.concepts.arrays;

public class ContainerWithMostWater {
    public int maxArea(int[] A) {
        int lo = 0, hi = A.length - 1;

        int area = 0;

        while (lo < hi) {
            area = Math.max(area, Math.min(A[lo], A[hi]) * (hi - lo));
            if (A[lo] < A[hi]) // hoping there is a better bar to trap more water
                lo++;
            else
                hi--;
        }


        return area;
    }
}
