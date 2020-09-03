package com.company.codingscales.interviews.facebook;

import com.company.codingscales.templates.LeetCodeInputHelpers;

import java.util.HashMap;

public class ContinuousSubarraySum {
    public static boolean checkSubarraySum(final int[] nums, final int k) {
        for (int start = 0; start < nums.length - 1; start++) {
            for (int end = start + 1; end < nums.length; end++) {
                int sum = 0;
                for (int i = start; i <= end; i++)
                    sum += nums[i];
                if (sum == k || (k != 0 && sum % k == 0))
                    return true;
            }
        }
        return false;
    }

    public static boolean checkSubarraySumCummulative(final int[] nums, final int k) {
        final int[] cum = new int[nums.length + 1];

        for(int i = 1; i < nums.length + 1; i++) {
            cum[i] = cum[i-1] + nums[i - 1];
        }


        for(int start = 0; start < nums.length - 1; start ++) {
            for (int end = start + 1; end < nums.length; end++) {
                final int total = cum[end] - cum[start];
                if (total == k || (k != 0 && total % k == 0))
                    return true;
            }
        }

        return false;
    }

    public boolean checkSubarraySumHashMap(final int[] nums, final int k) {
        // sum1 % k == sum2 % k => (sum1 - sum2) % k == 0
        // if sum1 is the whole array, then sum2 is 0
        // key is the % res and value is the index of it
        final HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (k != 0) {
                sum = sum % k;
            }

            if (map.containsKey(sum)) {
                if(i - map.get(sum) > 1)
                    return true; // the distance between the two
            } else {
                map.put(sum, i);
            }
        }

        return false;
    }

    public static void main(final String[] args) {
        System.out.println(checkSubarraySum(LeetCodeInputHelpers.stringToIntArray("[0,1,0]"), 0)); // false;
    }

}
