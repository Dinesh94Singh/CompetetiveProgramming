package com.company.codingscales.leetcode.concepts.arrays;

public class MinimumSizeSubarraySum {
    public static int minSubArrayLen(int s, int[] nums) {
        int start = 0, end = 0;
        int N = nums.length;
        int total = 0;
        int res = Integer.MAX_VALUE;
        while (end < N) {
            total += nums[end];
            while (total >= s && start <= end) {
                res = Math.min(res, end - start + 1);
                total -= nums[start];
                start++;
            }

            end++;
        }

        if (res == Integer.MAX_VALUE)
            return 0;
        return res;
    }

    public static void main(String[] args) {
        System.out.println("Res " + minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3})); // 2
        System.out.println("Res " + minSubArrayLen(11, new int[]{1, 2, 3, 4, 5})); // 3
    }
}
