package com.company.codingscales.leetcode.concepts.greedy;

public class MaxProduct {
    // MaxSubArray -> Kadane's algorithm
    // MaxProduct -> need to maintain, both min and max
    public static int maxProduct(final int[] nums) {
        if (nums.length == 0) return 0;

        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int result = max_so_far;

        for (int i = 1; i < nums.length; i++) {
            final int curr = nums[i];
            final int temp_max = Math.max(curr, Math.max(max_so_far * curr, min_so_far * curr));
            min_so_far = Math.min(curr, Math.min(max_so_far * curr, min_so_far * curr));
            max_so_far = temp_max;

            result = Math.max(max_so_far, result);
        }

        return result;
    }
}
