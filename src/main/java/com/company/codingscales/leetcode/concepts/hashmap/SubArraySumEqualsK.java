package com.company.codingscales.leetcode.concepts.hashmap;

import java.util.HashMap;

/**
 * Given an array of integers and an integer k,
 * you need to find the total number of continuous sub-arrays whose sum equals to k.
 */
public class SubArraySumEqualsK {
    public static int subarraySum(final int[] nums, final int k) {
        final HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1); // base condition
        int sum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            System.out.print("index " + i + " Sum => " + sum + " hm => " + hm + " Diff => " + (sum - k));

            if (hm.containsKey(sum - k)) { // sum1 + sum2 == k => sum2 => sum1 - k
                count += hm.get(sum - k); // increment count, by total number of occ
            }

            if (hm.containsKey(sum)) {
                hm.put(sum, hm.get(sum) + 1);
            } else {
                hm.put(sum, 1);
            }

            System.out.println(" count " + count);
        }

        return count;
    }

    public static void main(final String[] args) {
        System.out.println(subarraySum(new int[]{3,4,7,2,-3,1,4,2}, 7));
        System.out.println(subarraySum(new int[]{3,4,7,2,-3,1,4,2}, 100));
    }

}
