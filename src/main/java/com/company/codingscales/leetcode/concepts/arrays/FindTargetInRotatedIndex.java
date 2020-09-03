package com.company.codingscales.leetcode.concepts.arrays;

import java.util.Arrays;

public class FindTargetInRotatedIndex {
    int findRotatedIndex(int[] nums) {
        int n = nums.length;
        int mid;
        int lo = 0, hi = n - 1;
        while(lo < hi) {
            mid = (lo + (hi - lo) / 2);
            if (nums[mid] > nums[mid + 1])
                return mid + 1;
            else if (nums[mid] > nums[0]) {
                // still in the left half, move towards right hafl
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        int rotatedIndex = 0;
        if (nums[0] > nums[n - 1]){
            rotatedIndex = findRotatedIndex(nums);
        }

        if (rotatedIndex == 0) {
            int idx = Arrays.binarySearch(nums, 0, n, target);
            if (idx >= 0 && idx < n && nums[idx] == target)
                return idx;
            return -1;
        }

        if (nums[rotatedIndex] == target) {
            return rotatedIndex;
        } else if (nums[0] > target) {
            // search b/w rotated index ... n
            int idx = Arrays.binarySearch(nums, rotatedIndex, n, target);
            if (idx < n && idx >= 0 && nums[idx] == target) {
                return idx;
            }
            return -1;
        } else {
            // search b/w 0 ... rotatedIndex // lets make the rotatedIndex exclusive
            int idx = Arrays.binarySearch(nums, 0, rotatedIndex, target);
            if (idx < n && idx >= 0 && nums[idx] == target) {
                return idx;
            }
            return -1;
        }
    }
}
