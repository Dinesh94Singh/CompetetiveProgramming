package com.company.codingscales.leetcode.concepts.hashmap;

import java.util.HashMap;

/**
 * Given a list of non-negative numbers and a target integer k,
 * write a function to check if the array has a continuous sub-array of size at least 2 that sums up to a multiple of k,
 * that is, sums up to n*k where n is also an integer.
 *
 * <bold>Multiple of K, that's why we do mod</bold>
 */
public class ContinousSubArraySum {
    public static boolean checkSubarraySum(final int[] nums, final int k) {
        final HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // for case when target is 0 and there could be sum which leads to 0
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int remainder = sum;
            if (k != 0) {
                remainder = sum % k;
            }

            if (map.containsKey(remainder)) {
                // adding these 2 will add to k, and its size should be greater than or equal to 2
                if (i - map.get(remainder) > 1)
                    return true;
            } else {
                map.put(sum, i); // put the index
            }
        }

        return false;
    }
}
