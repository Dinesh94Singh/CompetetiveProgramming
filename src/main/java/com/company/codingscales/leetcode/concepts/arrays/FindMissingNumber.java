package com.company.codingscales.leetcode.concepts.arrays;

public class FindMissingNumber {
    private static void swap(int[] nums, int i, int j) {
        final int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public int missingNumber(int[] nums) {
        // cyclic sort
        int i = 0;

        while (i < nums.length) {
            int j = nums[i];
            if (j < nums.length && nums[i] != nums[j])
                swap(nums, i, j);
            else {
                i++;
            }
        }

        for(i = 0; i < nums.length; i++) {
            if (nums[i] != i)
                return i;
        }

        return nums.length;
    }

    public static int missingNumberBitManp(final int[] nums) {
        int xor = nums.length;
        for(int i = 0; i < nums.length; i++)
            xor ^= nums[i] ^ i;

        return xor;
    }
}
