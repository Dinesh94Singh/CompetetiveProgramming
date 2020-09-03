package com.company.codingscales.leetcode.concepts.miscellaneous;

public class MinStartValue {
    public int minStartValue(final int[] nums) {
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            boolean notSatisfied = false;
            int sum = i;
            for (int j = 0; j < nums.length; j++) {
                sum += nums[j];
                if (sum < 1) {
                    notSatisfied = true;
                    break;
                }
            }

            if (!notSatisfied)
                return i;
        }
        return -1;
    }
}
