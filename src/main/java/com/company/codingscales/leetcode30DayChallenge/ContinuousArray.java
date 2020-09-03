package com.company.codingscales.leetcode30DayChallenge;

import java.util.HashMap;

/**
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 * <p>
 * Example 1:
 * <p>
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 * <p>
 * Example 2:
 * <p>
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 */
public class ContinuousArray {
    public static int findMaxLength(final int[] nums) {
        // brute force - sliding window solution - TLE's
        int count = 0;
        int maxLength = Integer.MIN_VALUE;
        HashMap<Integer, Integer> countToIndexMap = new HashMap<>();
        countToIndexMap.put(0, -1);
        for(int i = 0; i < nums.length; i++) {
            count += nums[i] == 0 ? -1 : 1;
            if (countToIndexMap.containsKey(count)) {
                maxLength = Math.max(maxLength, i - countToIndexMap.get(count));
            } else {
                countToIndexMap.put(count, i);
            }
        }

        return maxLength != Integer.MIN_VALUE ? maxLength : 0;
    }

    public static void main(String[] args) {
    }

}
