package com.company.codingscales.leetcode.concepts.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NumberOfConnectedComponentsInUnDirectedGraph {
    static void dfs(int index, HashMap<Integer, List<Integer>> graph, boolean[] visited) {
        visited[index] = true;
        for(int each : graph.getOrDefault(index, new ArrayList<>())) {
            if (!visited[each])
                dfs(each, graph, visited);
        }
    }

    public static int countComponents(int n, int[][] edges) {
        int count = 0;
        boolean[] visited = new boolean[n];
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge : edges) {
            int x = edge[0], y = edge[1];
            graph.putIfAbsent(x, new ArrayList<>());
            graph.putIfAbsent(y, new ArrayList<>());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        for(int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, graph, visited);
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        System.out.println(countComponents(5, edges));
    }
}
