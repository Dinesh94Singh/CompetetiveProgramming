package com.company.codingscales.leetcode.concepts.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OptimalAccountBalancing {
    public int minTransfers(int[][] transactions) {
        HashMap<Integer, Integer> graph = new HashMap<>();
        for(int[] edge : transactions) {
            graph.putIfAbsent(edge[0], 0);
            graph.putIfAbsent(edge[1], 0);
            graph.put(edge[0], graph.get(edge[0]) + edge[2]);
            graph.put(edge[1], graph.get(edge[1]) - edge[2]);
        }

        List<Integer> list = new ArrayList<>();
        for(Integer i : graph.values()) {
            if (i != 0)
                list.add(i);
        }
        return dfs(0, list);
    }

    private int dfs(int index, List<Integer> list) {
        if (index == list.size()) { return 0; }

        int curr = list.get(index);
        if (curr == 0) { return dfs(index + 1, list); }

        int min = Integer.MAX_VALUE;
        for(int k = index + 1; k < list.size(); k++) {
            int other = list.get(k);
            if (other * curr < 0) {
                list.set(k, curr + other); // settle things up
                min = Math.min(min, 1 + dfs(index + 1, list)); // finding the global minimum
                list.set(k, other); // backtrack

                if (other + curr == 0) {
                    break;
                }
            }
        }

        return min;
    }
}
