package com.company.codingscales.leetcode.concepts.dynamicProgramming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FrogJump {
    Boolean[][] dp;
    boolean dfs(int[] stones, int idx, int jumpSize) {
        if (idx == stones.length - 1) {
            return true;
        }

        if (dp[idx][jumpSize] != null)
            return dp[idx][jumpSize];

        boolean possible = false;
        for(int i = idx + 1; i < stones.length; i++) { // going linear way
            int gap = stones[i] - stones[idx];

            if (gap >= jumpSize - 1 && gap <= jumpSize + 1)
                possible |= dfs(stones, i, gap);

            if (possible)
                break;
        }

        dp[idx][jumpSize] = possible;
        return possible;
    }

    boolean dfsWithBinarySearch(int[] stones, int idx, int jumpSize) {
        return false;
    }

    public boolean canCrossDFS(int[] stones) { // O(n^3)
        dp = new Boolean[stones.length][stones.length];
        return dfs(stones, 0, 0);
    }

    public boolean canCrossDP(int[] stones) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], new HashSet<>());
        }
        map.get(0).add(0);
        for (int i = 0; i < stones.length; i++) {
            for (int k : map.get(stones[i])) {
                for (int step = k - 1; step <= k + 1; step++) {
                    if (step > 0 && map.containsKey(stones[i] + step)) {
                        map.get(stones[i] + step).add(step);
                    }
                }
            }
        }
        return !map.get(stones[stones.length - 1]).isEmpty();
    }
}
