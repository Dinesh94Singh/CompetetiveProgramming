package com.company.codingscales.leetcode.concepts.hashmap;

import com.company.codingscales.templates.LeetCodeInputHelpers;

import java.util.HashMap;

public class SubArraySumEqualsK {
    public static int subarraySum(final int[] nums, final int k) {
        final HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1); // base condition
        int sum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            System.out.print("index " + i + " Sum => " + sum + " hm => " + hm + " Diff => " + (sum - k));

            if (hm.containsKey(sum - k)) {
                count += hm.get(sum - k);
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
        System.out.println(subarraySum(LeetCodeInputHelpers.stringToIntArray("[3,4,7,2,-3,1,4,2]"), 7));
        System.out.println(subarraySum(LeetCodeInputHelpers.stringToIntArray("[3,4,7,2,-3,1,4,2]"), 100));
    }

}
