package com.company.codingscales.leetcode.concepts.dynamicProgramming.knapsack;

import java.util.Arrays;

/**
 * DP solution available at {@link com.company.codingscales.leetcode.concepts.dynamicProgramming.bitMasking.PartitionToKEqualSumSubsets}
 */
public class PartitionToKEqualSumSubsets {
    // Backtracking, DP (bit manipulation available)
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = Arrays.stream(nums).reduce(0, Integer::sum);

        if (total % k != 0)
            return false;

        boolean[] visited = new boolean[nums.length];
        return dfs(0, nums, visited, k, total / k, 0);
    }

    boolean dfs(int index, int[] nums, boolean[] visited, int K, int target, int currTotal) {
        if (K == 1) {
            // ideally should be k == 0, but when k = 4, and u found 3 subsets, then its guaranteed that the remaining numbers will form a subset (recall 2 sum)
            return true;
        }

        if (currTotal == target) {
            return dfs(0, nums, visited, K - 1, target, 0);
        }

        for(int k = index; k < nums.length; k++) {
            if (!visited[k] && currTotal + nums[k] <= target) {
                visited[k] = true;
                if (dfs(k + 1, nums, visited, K, target, currTotal + nums[k]))
                    return true;
                visited[k] = false;
            }
        }

        return false;
    }
}
