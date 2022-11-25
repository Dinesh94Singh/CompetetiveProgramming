package com.company.codingscales.leetcode.concepts.backtracking;

import java.util.*;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        LinkedList<Integer> comb = new LinkedList<>();

        Arrays.sort(candidates);

        backtrack(candidates, comb, target, 0, results);
        return results;
    }

    private void backtrack(int[] candidates, LinkedList<Integer> comb, Integer remain, Integer idx, List<List<Integer>> results) {
        if (remain == 0) {
            // copy the current combination to the final list.
            results.add(new ArrayList<Integer>(comb));
            return;
        }

        for (int i = idx; i < candidates.length; ++i) {
            if (i > idx && candidates[i] == candidates[i - 1]) // you can choose once, but after that, don't choose in this
                continue;

            Integer pick = candidates[i];
            // optimization: early stopping
            if (remain - pick < 0)
                break;

            comb.addLast(pick);
            backtrack(candidates, comb, remain - pick, i + 1, results);
            comb.removeLast();
        }
    }
}
