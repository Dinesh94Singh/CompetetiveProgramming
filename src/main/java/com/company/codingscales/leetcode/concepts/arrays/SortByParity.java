package com.company.codingscales.leetcode.concepts.arrays;

public class SortByParity {
    public int[] sortArrayByParity(int[] nums) {
        int i = 0, j = nums.length - 1;

        while (i < j) {
            boolean shouldSwap = nums[i] % 2 != 0 && nums[j] % 2 == 0;

            if (shouldSwap) {
                swap(nums, i, j);
            }

            if (nums[i] % 2 == 0)
                i++;
            if (nums[j] % 2 != 0)
                j--;
        }

        return nums;
    }

    void swap(int[] A, int i, int j) {
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }
}
