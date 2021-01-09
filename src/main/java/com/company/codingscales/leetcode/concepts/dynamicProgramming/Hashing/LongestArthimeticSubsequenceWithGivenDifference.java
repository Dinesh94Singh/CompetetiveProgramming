package com.company.codingscales.leetcode.concepts.dynamicProgramming.Hashing;

import java.util.HashMap;

/**
 * Similar to Two sum. See if diff - num exisits in hashmap. Since, we are moving in 1 direction only, we can solidify the longest a.p with given differnece
 */
public class LongestArthimeticSubsequenceWithGivenDifference {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        int longest = 0;
        for (final int num : arr) {
            dp.put(num, dp.getOrDefault(num - difference, 0) + 1);
            longest = Math.max(longest, dp.get(num));
        }
        return longest;
    }
}
