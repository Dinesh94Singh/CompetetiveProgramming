package com.company.codingscales.interviews.facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

// Asked in facebook phone screen
public class RandomPickIndex {
    private int[] nums;

    private Random rand;

    HashMap<Integer, List<Integer>> map;
    public RandomPickIndex(int[] nums) {
        // Do not allocate extra space for the nums array
        map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int x = nums[i];
            map.putIfAbsent(x, new ArrayList<>());
            map.get(x).add(i);
        }
    }

    public int pick(int target) {
        List<Integer> l = map.getOrDefault(target, new ArrayList<>());
        if (l.isEmpty())
            return -1;
        return l.get(rand.nextInt(l.size()));
    }

    static class Solution {
        // Using Reservoir Sampling
        private int[] nums;
        private Random rand;

        public Solution(int[] nums) {
            this.nums = nums;
            this.rand = new Random();
        }

        public int pick(int target) {
            int n = this.nums.length;
            int count = 0;
            int idx = 0;
            for (int i = 0; i < n; ++i) {
                // if nums[i] is equal to target, i is a potential candidate
                // which needs to be chosen uniformly at random
                if (this.nums[i] == target) {
                    // increment the count of total candidates
                    // available to be chosen uniformly at random
                    count++;
                    // we pick the current number with probability 1 / count (reservoir sampling)
                    if (rand.nextInt(count) == 0) {
                        idx = i;
                    }
                }
            }
            return idx;
        }
    }
}
