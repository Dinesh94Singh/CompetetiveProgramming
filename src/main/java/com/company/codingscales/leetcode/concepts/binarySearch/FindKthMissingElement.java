package com.company.codingscales.leetcode.concepts.binarySearch;

public class FindKthMissingElement {
    public int findKthPositive(int[] A, int k) {
        // going linear is going to be costly, if k is very huge
        int lo = 0;
        int hi = A.length - 1;

        while (lo <= hi) {
            int mid = (lo + (hi - lo) / 2);

            int missingSoFar = A[mid] - mid - 1;

            if (missingSoFar < k) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        // return A[hi] + k - (A[hi] - hi - 1); // refer to good notes for explanation => k + hi + 1 => we know, lo is at hi + 1 => k + lo.
        return lo + k;
    }
}
