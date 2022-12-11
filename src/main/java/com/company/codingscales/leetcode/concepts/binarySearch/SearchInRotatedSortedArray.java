package com.company.codingscales.leetcode.concepts.binarySearch;

public class SearchInRotatedSortedArray {
    public int search(int[] A, int target) {
        int rotatedIndex = 0;
        int N = A.length;
        if (N == 1)
            return A[0] == target ? 0 : -1;

        if (A[0] > A[N - 1]) {
            rotatedIndex = findRotatedIdx(A);
        } else {
            return binarySearch(A, 0, N, target);
        }

        if (target == A[rotatedIndex]) {
            return rotatedIndex;
        } else if (target > A[N - 1]) {
            return binarySearch(A, 0, rotatedIndex, target);
        } else {
            return binarySearch(A, rotatedIndex, N, target);
        }
    }

    private int findRotatedIdx(int[] A) {
        int lo = 0;
        int hi = A.length - 1;
        int N = A.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            //                           v
            if (A[0] <= A[mid]) { // 4 5 6 1 2 4
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return lo;
    }

    private int binarySearch(int[] A, int start, int end, int target) { // need to do, binary search twice.
        while (start <= end && start < A.length) {
            int mid = (start + (end - start) / 2);
            if (A[mid] == target)
                return mid;
            else if (A[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }

        return -1;
    }


    // NOTE: USE THIS SOLUTION
    public int search_single_binary_search(int[] A, int target) {
        int lo = 0, hi = A.length - 1;
        int mid = 0;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;

            if (A[mid] == target) {
                return mid;
            }

            if (A[lo] <= A[mid]) { // lo ... mid is sorted
                if (A[lo] <= target && target < A[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else { // mid + 1 ... hi is sorted
                if (A[mid] <= target && target <= A[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }
}
