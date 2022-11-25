package com.company.codingscales.leetcode.concepts.math;

public class MissingNumberInArthemeticProgression {
    public int missingNumber(int[] arr) {
        int diff = (arr[arr.length - 1] - arr[0]) / arr.length;

        int lo = 0, hi = arr.length - 1;

        /**
         * by mid we would have mid * diff + arr[0]
         *
         * at = diff * t + a[0]
         */
        while (lo < hi) {
            int mid = (lo + (hi - lo) / 2);

            if (arr[mid] == arr[0] + mid * diff) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return arr[0] + diff * lo;
    }
}
