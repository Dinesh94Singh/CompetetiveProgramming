package com.company.codingscales.leetcode.concepts.binarySearch;

public class SearchInRotatedSortedArray2 {
    public static boolean search(int[] A, int target) {
        int lo = 0, hi = A.length - 1;
        int mid = 0;
        while (lo <= hi) {
            while (lo < hi && A[lo] == A[lo + 1]) {
                lo++; // skip dups
            }

            while (lo < hi && A[hi] == A[hi - 1]) {
                hi--; // skip dups
            }

            mid = lo + (hi - lo) / 2;

            if (A[mid] == target) {
                return true;
            }


            if (A[lo] <= A[mid]) { // lo ... mid is sorted
                if (A[lo] <= target && target < A[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else { // mid + 1 ... hi is sorted
                if (A[mid] < target && target <= A[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }

        return false;
    }
}
