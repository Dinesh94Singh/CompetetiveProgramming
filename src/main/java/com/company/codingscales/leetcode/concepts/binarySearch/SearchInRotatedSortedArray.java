package com.company.codingscales.leetcode.concepts.binarySearch;

import java.util.Arrays;

public class SearchInRotatedSortedArray {
    private int findRotIndex(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + (right - left) / 2);
            if (nums[mid] > nums[mid + 1])
                return mid + 1;

            if (nums[mid] > nums[nums.length - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left + 1;
    }

    static int findRotatingIndex(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + (hi - lo) / 2);
            if (nums[mid] < nums[0]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    public int search(int[] nums, int target) {
        int N = nums.length - 1;
        int rotIndex = 0;
        if (nums[0] > nums[N]) {
            rotIndex = findRotIndex(nums);
        }

        if (rotIndex == 0) {
            int val = Arrays.binarySearch(nums, 0, nums.length, target);
            if (val < 0)
                return -1;
            return val;
        }

        if (nums[rotIndex] == target) {
            return rotIndex;
        } else if (nums[nums.length - 1] < target) {
            int val = Arrays.binarySearch(nums, 0, rotIndex, target);
            if (val < 0)
                return -1;
            return val;
        } else {
            int val = Arrays.binarySearch(nums, rotIndex, nums.length, target);
            if (val < 0)
                return -1;
            return val;
        }
    }
}
