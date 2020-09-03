package com.company.codingscales.interviews.microsoft;

import java.util.Arrays;

public class MaxChunksOfSortArray {
    public static void main(final String[] args) {
        final int[] nums1 = {2,4,1,6,5,9,7};
        final int[] nums2 = {4,3,2,6,1};
        final int[] nums3 = {2,1,6,4,3,7};
        System.out.println(solve(nums1));
        System.out.println(solve(nums2));
        System.out.println(solve(nums3));
    }

    private static int solve(final int[] nums) {
        int res = 0;
        double copySum = 0, oriSum = 0;
        final int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        for(int i=0;i<nums.length;i++) {
            copySum += copy[i];
            oriSum += nums[i];
            if(copySum == oriSum)
                res++;
        }
        return res;
    }
}
