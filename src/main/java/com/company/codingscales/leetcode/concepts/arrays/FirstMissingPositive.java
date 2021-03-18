package com.company.codingscales.leetcode.concepts.arrays;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        boolean containsOne = false;
        for(int a : nums) {
            if (a == 1) {
                containsOne = true;
                break;
            }
        }

        if (!containsOne)
            return 1;

        if (nums.length == 1)
            return 2;

        int N = nums.length;

        for(int i = 0; i < N; i++) {
            if (nums[i] <= 0 || nums[i] > N) {
                nums[i] = 1;
            }
        }

        for(int i = 0; i < N; i++) { // now the array becomes, 1 --- N
            int idx = Math.abs(nums[i]);
            nums[idx % N] = -(Math.abs(nums[idx % N]));
        }

        for(int i = 1; i < N; i++)
            if (nums[i] > 0) // never visited
                return i;
        if (nums[0] > 0)
            return N;
        return N + 1; // all N present, return the next value
    }
}
