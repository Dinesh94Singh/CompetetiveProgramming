package com.company.codingscales.leetcode.concepts.math;

public class sqrtX {
    public int mySqrt(int x) {
        if (x == 0 || x == 1)
            return x;
        int left = 2;
        int right = x / 2;

        while (left <= right) {
            final int pivot = left + (right - left) / 2;

            final long num = (long) pivot * pivot;

            if (num > x) {
                right = pivot - 1;
            } else if (num < x) {
                left = pivot + 1;
            } else {
                return pivot;
            }
        }

        return right;
    }
}
