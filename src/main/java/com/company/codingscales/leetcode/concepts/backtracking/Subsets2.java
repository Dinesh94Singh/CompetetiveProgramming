package com.company.codingscales.leetcode.concepts.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Remove Duplicates */
public class Subsets2 {
    List<List<Integer>> res;
    private void dfs(final int index, final int[] nums, final List<Integer> path) {
        res.add(new ArrayList<>(path));

        int i = index;
        while (i < nums.length) {
            path.add(nums[i]);
            dfs(i + 1, nums, path);
            path.remove(path.size() - 1);

            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
            i++;
        }
    }

    public List<List<Integer>> subsets(final int[] nums) {
        Arrays.sort(nums);
        final List<Integer> path = new ArrayList<>();
        res = new ArrayList<>();
        dfs(0, nums, path);
        return res;
    }
}
