package com.company.codingscales.leetcode.concepts.arrays;

public class SearchInRotatedSortedArray2 {
    public boolean search(int[] A, int target) {
        int lo = 0;
        int hi = A.length;


        while (lo < hi) {
            int mid = (lo + (hi - lo) / 2);

            if (A[mid] == target)
                return true;
            else if (A[mid] > A[lo]) {
                if (target < A[mid] && target >= A[lo]) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            } else if (A[mid] < A[lo]) {
                if (target > A[mid] && target < A[lo]) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            } else {
                lo++;
            }
        }

        return false;
    }
}
