package com.company.codingscales.leetcode.concepts.dynamicProgramming.bitMasking;

import java.util.Arrays;

/**
 * Refer the backtracking solution here - {@link com.company.codingscales.leetcode.concepts.dynamicProgramming.knapsack.PartitionToKEqualSumSubsets}
 * // Did not understand this solution. TODO: Revise again
 *
 * BitMask Guide:
 * -------------
 *  To set a bit to 1: mask = mask | (1 << bitIndex)
 *  To set a bit to 0: mask = mask & ~(1 << bitIndex)
 *  To get a bit (to be able to check it): (mask & (1 << bitIndex)) != 0
 */
public class PartitionToKEqualSumSubsets {
    /**
     * dp[i] indicates whether array of length i can partitioned into k subsets of equal sum.
     * Using this technique, the last index of this dp array
     * will tell whether the whole array can be partitioned into k subsets of equal sum.
     *
     * total[i] stores the sum of subset with sum less than equal to target sum.
     *
     * TC: O(N*2^N)
     * SC: O(2^N)
     */
    public boolean canPartitionKSubsets(final int[] nums, final int k) {
        if (nums == null || nums.length == 0)
            return false;

        int n = nums.length;
        final boolean[] dp = new boolean[1 << n]; // similar to 2 ^ n
        final int[] total = new int[1 << n]; // similar to 2 ^ n

        dp[0] = true; // base-case, when there are no elements to fill the target => true;

        Arrays.sort(nums);
        int sigma = Arrays.stream(nums).reduce(0, Integer::sum);
        if (sigma % k != 0)
            return false;
        sigma /= k; // sigma is the target

        for(int i = 0; i < (1 << n); i++) { // i < 2^n
            if (dp[i]) {
                for(int j = 0; j < n; j++) { // loop through each element to see, if it belongs to a subset
                    int temp = i | (1 << j); // set ith bit
                    if (temp != i) { // if not already set, then we can use it.
                        if (nums[j] <= (sigma - total[i] % sigma)) {
                            dp[temp] = true;
                            total[temp] = nums[j] + total[i];
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        return dp[(1 << n) - 1];
    }

    public static void main(String[] args) {
        PartitionToKEqualSumSubsets sol = new PartitionToKEqualSumSubsets();
        sol.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4);
    }
}
