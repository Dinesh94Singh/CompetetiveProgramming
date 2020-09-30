package com.company.codingscales.leetcode.concepts.dynamicProgramming.longestStrings;

public class MinimumDeletionsToMakeASequenceSorted {
    int minimumDeletionsToMakeSequenceSorted(int[] nums) {
        return nums.length - LongestIncreasingSubsequence.LISBottomUp(nums);
    }
}
