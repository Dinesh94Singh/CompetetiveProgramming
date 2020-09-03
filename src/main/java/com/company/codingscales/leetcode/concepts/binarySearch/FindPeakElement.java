package com.company.codingscales.leetcode.concepts.binarySearch;

import com.company.codingscales.templates.LeetCodeInputHelpers;

public class FindPeakElement {
    private static int binarySearch(final int[] nums, final int low, final int high) {
        if (low == high) return low;

        final int mid = low + (high - low) / 2;

        if (nums[mid] > nums[mid + 1]) {
            return binarySearch(nums, low, mid);
        }

        return binarySearch(nums, mid + 1, high);
    }

    public static int findPeakElement(final int[] nums) {
        final int i = 0;
        final int j = nums.length;

        return binarySearch(nums, i, j);
    }

    public static void main(final String[] args) {
        System.out.println(findPeakElement(LeetCodeInputHelpers.stringToIntArray("[1,2,3,1]")));
        System.out.println(findPeakElement(LeetCodeInputHelpers.stringToIntArray("[1,2,1,3,5,6,4]")));
    }
}
