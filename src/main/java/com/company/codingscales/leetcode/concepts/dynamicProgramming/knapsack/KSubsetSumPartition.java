package com.company.codingscales.leetcode.concepts.dynamicProgramming.knapsack;

import java.util.Arrays;

public class KSubsetSumPartition {
    // Backtracking, DP (bit manipulation available)
    public boolean canPartitionKSubsets(final int[] nums, final int k) {
       final int total = Arrays.stream(nums).reduce(0, Integer::sum);
       if (total % k != 0)
           return false;

        final boolean[] visited = new boolean[nums.length];
        return dfs(nums, k, visited, total / k, 0, 0);
    }

    boolean dfs(final int[] nums, final int k, final boolean[] visited, final int target, final int currSum, final int nxtIdx) {
        if (k == 1) // ideally should be k == 0, but when k = 4, and u found 3 subsets, then its guaranteed that the remaining numbers will form a subset (recall 2 sum)
            return true;
        if (currSum == target)
            return dfs(nums, k - 1, visited, target, 0, 0);

        for(int i = nxtIdx; i < nums.length; i++) {
            if (!visited[i] && currSum + nums[i] <= target) {
                visited[i] = true;
                if (dfs(nums, k, visited, target, currSum + nums[i], i + 1))
                    return true;
                visited[i] = false;
            }
        }

        return false;
    }
}
