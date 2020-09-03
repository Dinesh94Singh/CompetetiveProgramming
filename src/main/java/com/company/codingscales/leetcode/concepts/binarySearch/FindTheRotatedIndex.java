package com.company.codingscales.leetcode.concepts.binarySearch;

import java.util.Arrays;

public class FindTheRotatedIndex {
    private int findRotateIndex(final int[] nums) {
        final int n = nums.length;

        if (nums[0] <= nums[n-1]) return 0;

        int start = 0;
        int end = n - 1;

        while (start < end) {
            final int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid + 1])
                return mid + 1;
            else if (nums[mid] < nums[mid + 1] && nums[mid] > nums[0]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    public int search(final int[] nums, final int target) {
        if (nums.length == 0) return -1;
        else if (nums.length == 1) return nums[0] == target ? 0 : -1;

        final int rotatedIndex = findRotateIndex(nums);
        if (rotatedIndex == 0) {
            final int idx = Arrays.binarySearch(nums, target);
            if (idx < 0 || nums[idx] != target) return -1; // element not found in the array
            return idx;
        }

        if (nums[rotatedIndex] == target) {
            return rotatedIndex;
        } else if (nums[rotatedIndex] <= target && target <= nums[nums.length  - 1]) {
            final int idx = Arrays.binarySearch(nums, rotatedIndex, nums.length, target);
            if (idx < 0 || nums[idx] != target) return -1; // element not found in the array
            return idx;
        } else {
            final int idx = Arrays.binarySearch(nums,0, rotatedIndex, target);
            if (idx < 0 || nums[idx] != target) return -1; // element not found in the array
            return idx;
        }
    }

    public static void main(final String[] args) {
        final FindTheRotatedIndex f = new FindTheRotatedIndex();
        System.out.println(f.search(new int[]{1, 2, 3, 4}, 2)); // 1
        System.out.println(f.search(new int[]{4, 3, 2, 1}, 2)); // 2
        System.out.println(f.search(new int[]{1}, 1)); // 0
        System.out.println(f.search(new int[]{1}, 2)); // -1
        System.out.println(f.search(new int[]{1, 2}, 1)); // 0
        System.out.println(f.search(new int[]{1, 2}, 2)); // 1
        System.out.println(f.search(new int[]{2, 1}, 1)); // 1
        System.out.println(f.search(new int[]{2, 1}, 2)); // 0
        System.out.println(f.search(new int[]{4,5,6,7,0,1,2}, 0)); // 4
        System.out.println(f.search(new int[]{1, 3}, 2)); // -1
        System.out.println(f.search(new int[]{5, 1, 3}, 0)); // -1
        System.out.println(f.search(new int[]{5, 1, 3},  5)); // 0
        System.out.println(f.search(new int[]{4, 5, 1, 2, 3},  1)); // 2
    }
}
