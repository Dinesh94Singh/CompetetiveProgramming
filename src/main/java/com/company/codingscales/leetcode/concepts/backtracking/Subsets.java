package com.company.codingscales.leetcode.concepts.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    List<List<Integer>> res;
    private void dfs(int index, int[] nums, List<Integer> path) {
        res.add(new ArrayList<>(path));

        for(int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(i + 1, nums, path);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> subsets(final int[] nums) {
        List<Integer> path = new ArrayList<>();
        res = new ArrayList<>();
        dfs(0, nums, path);
        return res;
    }
}
