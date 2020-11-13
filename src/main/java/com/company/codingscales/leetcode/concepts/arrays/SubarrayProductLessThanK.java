package com.company.codingscales.leetcode.concepts.arrays;

public class SubarrayProductLessThanK {
    // sliding window with prod
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1)
            return 0;
        int prod = 1, start = 0, count = 0, end = 0;

        while(end < nums.length) {
            int val = nums[end];
            prod *= val;

            while (prod >= k) {
                prod /= nums[start];
                start++;
            }

            count += (end - start  + 1);
            end++;
        }
        return count;
    }
}
