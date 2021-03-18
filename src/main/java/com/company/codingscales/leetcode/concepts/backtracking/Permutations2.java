package com.company.codingscales.leetcode.concepts.backtracking;

import java.util.*;
import java.util.stream.Collectors;

/** Skip Duplicates **/
public class Permutations2 {
    static List<List<Integer>> res = new ArrayList<>();

    /**
     * Swap each element from i => N with ith element and do dfs i + 1th step
     */
    static void dfs(final int i, final List<Integer> nums, final List<Integer> list) {
        if (i == nums.size()) {
            res.add(new ArrayList<>(list));
            return;
        }

        final HashSet<Integer> appeared = new HashSet<>();
        for(int k = i; k < nums.size(); k++) {
            if (appeared.add(nums.get(k))) {
                Collections.swap(nums, i, k);
                dfs(i + 1, nums, list);
                Collections.swap(nums, i, k);
            }
        }
    }

    static void swap(final int[] nums, final int i, final int j) {
        final int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static List<List<Integer>> permute(final int[] nums) {
        final List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        dfs(0, list, new ArrayList<>());
        return res;
    }

    public static void main(String[] args) {
        permute(new int[]{1, 1, 2});
    }

}
