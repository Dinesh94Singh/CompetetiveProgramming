package com.company.codingscales.leetcode.concepts.backtracking;

import java.util.ArrayList;
import java.util.List;

/** Remove Duplicates */
public class Subsets2 {
    List<List<Integer>> res;
    private void dfs(final int index, final int[] nums, final List<Integer> path) {
        res.add(new ArrayList<>(path));

        for(int i = index; i < nums.length; i++) {
            if (i > index && nums[i - 1] == nums[i])
                continue;
            path.add(nums[i]);
            dfs(i + 1, nums, path);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> subsets(final int[] nums) {
        final List<Integer> path = new ArrayList<>();
        res = new ArrayList<>();
        dfs(0, nums, path);
        return res;
    }
}
