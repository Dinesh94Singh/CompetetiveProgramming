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
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // [23, 2, 4, 6, 6] (total = 7) => true

        int sum = 0;

        for(int i = 0; i < nums.length; i++) {
            int a = nums[i];


            sum += a;
            if (k != 0) {
                sum %= k;
            }

            if (map.containsKey(sum)) {
                int idx = map.get(sum);

                if (i - idx > 1) {
                    return true;
                }
            } else {
                map.put(sum, i);
            }
        }

        return false;
    }
}
