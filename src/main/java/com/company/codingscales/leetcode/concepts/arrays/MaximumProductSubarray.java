package com.company.codingscales.leetcode.concepts.arrays;

public class MaximumProductSubarray {
    int maxProduct(int[] arr) {
        int max = arr[0];
        int min = arr[0];

        int res = arr[0];

        for(int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                int t = max;
                max = Math.max(min * arr[i], arr[i]);
                min = Math.min(t * arr[i], arr[i]);
            } else {
                max = Math.max(arr[i], max * arr[i]);
                min = Math.min(arr[i], min * arr[i]);
            }

            res = Math.max(res, max);
        }

        return res;
    }
}
