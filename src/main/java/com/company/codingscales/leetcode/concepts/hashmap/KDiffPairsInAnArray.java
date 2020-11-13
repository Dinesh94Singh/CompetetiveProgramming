package com.company.codingscales.leetcode.concepts.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class KDiffPairsInAnArray {
    public int findPairs(int[] nums, int k) {
        int result = 0;

        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int n : nums) {
            counter.put(n, counter.getOrDefault(n, 0) + 1);
        }


        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            int x = entry.getKey();
            int val = entry.getValue();
            if (k > 0 && counter.containsKey(x + k)) {
                result++;
            } else if (k == 0 && val > 1)
                result++;
        }
        return result;
    }

    public int findPairs2Pointers(int[] nums, int k) {
        Arrays.sort(nums);

        int left = 0, right = 1;
        int result = 0;

        while (left < nums.length && right < nums.length) {
            if (left == right || nums[right] - nums[left] < k) {
                // List item 1 in the text
                right++;
            } else if (nums[right] - nums[left] > k) {
                // List item 2 in the text
                left++;
            } else {
                // List item 3 in the text
                left++;
                result++;
                while (left < nums.length && nums[left] == nums[left - 1]) // skip duplicates
                    left++;
            }
        }
        return result;
    }
}
