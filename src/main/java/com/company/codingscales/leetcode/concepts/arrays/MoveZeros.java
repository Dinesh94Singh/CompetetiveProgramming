package com.company.codingscales.leetcode.concepts.arrays;

public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int p1 = 0;
        int p2 = 0;
        while (p1 < nums.length) {
            if (nums[p1] != 0) {
                swap(nums, p1, p2);
                p2++;
            }
            p1++;
        }
    }

    private void swap(int[] A, int i, int j) {
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }
}
