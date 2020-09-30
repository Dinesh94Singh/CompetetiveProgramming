package com.company.codingscales.leetcode.concepts.dynamicProgramming.longestStrings;

public class LongestBitonicSubsequence {

    static Integer[][] dpIncreasing;
    static Integer[][] dpDecreasing;

    static int dfsIncreasing(int index, int prevIndex, int[] nums) {
        if (index == nums.length)
            return 0;
        if (dpIncreasing[index][prevIndex] != null)
            return dpIncreasing[index][prevIndex];

        int c1 = 0;
        if (prevIndex == -1 || nums[index] < nums[prevIndex])
            c1 = 1 + dfsIncreasing(index + 1, index, nums);

        int c2 = dfsIncreasing(index + 1, prevIndex, nums);

        dpIncreasing[index][prevIndex] = Math.max(c1, c2);
        return dpIncreasing[index][prevIndex];
    }

    static int dfsDecreasing(int index, int prevIndex, int[] nums) {
        if (index < 0)
            return 0;
        if (dpDecreasing[index][prevIndex] != null)
            return dpDecreasing[index][prevIndex];

        int c1 = 0;
        if (prevIndex == -1 || nums[index] < nums[prevIndex])
            c1 = 1 + dfsDecreasing(index - 1, index, nums);
        int c2 = dfsDecreasing(index - 1, prevIndex, nums);

        dpDecreasing[index][prevIndex] = Math.max(c1, c2);
        return dpDecreasing[index][prevIndex];
    }

    static int LBS(int[] nums) {
        int maxLength = 0;

        dpIncreasing = new Integer[nums.length][nums.length + 1];
        dpDecreasing = new Integer[nums.length][nums.length + 1];

        for(int i = 0; i < nums.length; i++) {
            int c1 = dfsIncreasing(i, -1, nums);
            int c2 = dfsDecreasing(i, -1, nums);

            maxLength = Math.max(c1 + c2 - 1, maxLength);
        }

        return maxLength;
    }

    static int LBSBottomUp(int[] nums) {
        int[] dpIncreasing = new int[nums.length];
        int[] dpDecreasing = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            dpIncreasing[i] = 1;
            for(int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    dpIncreasing[i] = Math.max(dpIncreasing[i], dpIncreasing[j] + 1);
                }
            }
        }

        for(int i = nums.length - 1; i >= 0; i--) {
            dpDecreasing[i] = 1;
            for(int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    dpDecreasing[i] = Math.max(dpDecreasing[i], dpDecreasing[j] - 1);
                }
            }
        }

        int maxLength = 0;
        for(int i = 0; i < nums.length; i++) {
            maxLength = Math.max(maxLength, dpIncreasing[i] + dpDecreasing[i] - 1);
        }

        return maxLength;
    }
}
