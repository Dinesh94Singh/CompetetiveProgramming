package com.company.codingscales.leetcode.concepts.hashmap;

import java.util.HashMap;

public class MaximumSizeSubarrayOfSumEqualsK {
    public int maxSubArrayLen(int[] nums, int k) {
        // sliding window o(n^2)
        // map -> we know target => 1 - k => idx, 1+-1-k => idx, 1-1+5 => idx ... if you see the occurrence, then you can say its there

        HashMap<Integer, Integer> map = new HashMap<>();

        int total = 0;
        int maxLength = 0;
        for(int i = 0; i < nums.length; i++) {
            total += nums[i];

            if (total == k)
                maxLength = i + 1;

            if (map.containsKey(total - k)) {
                maxLength = Math.max(maxLength, i - map.get(total - k));
            } else if (!map.containsKey(total)) {
                map.put(total, i);
            }
        }

        return maxLength;
    }
}
