package com.company.codingscales.leetcode.concepts.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

// Very Important problem of 2020.
// TODO: LEARN Reservoir Sampling
public class RandomPickIndices {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    public RandomPickIndices(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
    }

    public int pick(int target) {
        List<Integer> indexes = map.getOrDefault(target, null);
        if (indexes == null)
            return -1;

        Random rand = new Random();
        int idx = rand.nextInt(indexes.size());
        return indexes.get(idx);
    }
}
