package com.company.codingscales.leetcode.concepts.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {
    List<List<Integer>> res = new ArrayList<>();


    /**
     * Swap each element from i => N with ith element and do dfs i + 1th step
     */
    void dfs(final int i, final int[] nums) {
        if (i == nums.length) {
            res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }

        for(int k = i; k < nums.length; k++) {
            swap(nums, k, i);
            dfs(i + 1, nums);
            swap(nums, k, i);
        }
    }

    static void swap(final int[] nums, final int i, final int j) {
        final int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public List<List<Integer>> permute(final int[] nums) {
        dfs(0, nums);
        return res;
    }
}
