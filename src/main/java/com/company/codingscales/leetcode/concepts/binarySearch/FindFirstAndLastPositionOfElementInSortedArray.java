package com.company.codingscales.leetcode.concepts.binarySearch;


public class FindFirstAndLastPositionOfElementInSortedArray {
    // java doesn't guarantee, lower bound and upper bound when there are duplicate numbers.
    static int binarySearch(final int[] nums, final int target, final boolean isLeft) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            final int mid = (left + (right - left) / 2);
            if (nums[mid] > target || (isLeft && nums[mid] == target)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public int[] searchRange(int[] nums, int target) {
        final int lowerBound = binarySearch(nums, target, true);
        if (lowerBound == nums.length || nums[lowerBound] != target) {
            return new int[] {-1, -1};
        }

        final int upperBound = binarySearch(nums, target, false);
        return new int[]{lowerBound, upperBound};
    }
}
