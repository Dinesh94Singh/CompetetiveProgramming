package com.company.codingscales.leetcode.concepts.binarySearch;

public class FindFirstAndLastPositionOfBinarySearch {
    public int[] searchRange(int[] nums, int target) {
        int leftMost = bs(nums, target, true);

        if (leftMost == -1)
            return new int[]{-1, -1};

        int rightMost = bs(nums, target, false);
        return new int[] {leftMost, rightMost - 1};
    }

    private int bs(int[] A, int t, boolean isLeft) {
        int lo = 0, hi = A.length - 1;
        boolean found = false;
        while (lo <= hi) {
            int mid = (lo + (hi - lo) / 2);

            if (A[mid] == t) {
                found = true;
                if (isLeft) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else if (A[mid] < t) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        if (!found)
            return -1;
        return lo;
    }
}
