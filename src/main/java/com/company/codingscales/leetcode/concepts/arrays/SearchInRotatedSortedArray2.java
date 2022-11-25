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

    // Use this

    public boolean searchRevisited(int[] nums, int target) {
        if (null == nums || 0 == nums.length)
            return false;

        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            // to avoid duplicates
            while (lo < hi && nums[lo] == nums[lo + 1])
                ++lo;
            while (lo < hi && nums[hi] == nums[hi - 1])
                --hi;

            // the code below is exactly the same with Problem 33.
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target)
                return true;

            if (nums[mid] >= nums[lo]) {
                if (target >= nums[lo] && target < nums[mid])
                    hi = mid - 1;
                else
                    lo = mid + 1;
            } else {
                if (target <= nums[hi] && target > nums[mid])
                    lo = mid + 1;
                else
                    hi = mid - 1;
            }
        }

        return false;
    }
}
