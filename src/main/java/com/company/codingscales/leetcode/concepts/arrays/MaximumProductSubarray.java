package com.company.codingscales.leetcode.concepts.arrays;

public class MaximumProductSubarray {
    int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];

        int ans = nums[0];

        for(int i = 1; i < nums.length; i++) {
            int each = nums[i];
            if (each >= 0) {
                max = Math.max(each * max, each);
                min = Math.min(each * min, each);
            } else {
                int t = max;
                max = Math.max(each * min, each);
                min = Math.min(each * t, each);
            }

            ans = Math.max(max, ans);
        }

        return ans;
    }
}
