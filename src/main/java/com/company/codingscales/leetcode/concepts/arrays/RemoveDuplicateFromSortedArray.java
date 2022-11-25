package com.company.codingscales.leetcode.concepts.arrays;

public class RemoveDuplicateFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int i = 0, j = 0;

        while (i < nums.length) {
            int t = nums[i];

            swap(nums, i, j);

            i++;
            j++;

            while (i < nums.length && nums[i] == t) { // skip duplicates
                i++;
            }
        }

        return j;
    }

    void swap(int[] A, int i, int j) {
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }


    public static void main(String[] args) {
        RemoveDuplicateFromSortedArray sol = new RemoveDuplicateFromSortedArray();
        sol.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
    }
}
