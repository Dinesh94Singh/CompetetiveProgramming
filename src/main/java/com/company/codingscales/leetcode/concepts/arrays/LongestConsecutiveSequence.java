package com.company.codingscales.leetcode.concepts.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;
        HashSet<Integer> hs = new HashSet<>(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        int res = Integer.MIN_VALUE;
        for(int a : nums) {
            if (!hs.contains(a-1)) {
                int length = 1;
                int k = a + 1;
                while (hs.contains(k)) {
                    length++;
                    k++;
                }
                res = Math.max(res, length);
            }
        }

        return res;
    }
}
