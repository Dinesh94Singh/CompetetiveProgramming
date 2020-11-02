package com.company.codingscales.binarysearchio.concepts.graphs;

import java.util.ArrayList;
import java.util.HashMap;

// Graph Coloring
public class CountryRoads {
    int[] ans = {0, 0};
    HashMap<Integer, ArrayList<Integer>> graph;
    int[] population;

    private void dfs(int node, int parent, int color) {
        ans[color] += population[node];

        for(int adjNode : graph.getOrDefault(node, new ArrayList<>())) {
            if (adjNode == parent)
                continue;
            dfs(adjNode, node, color == 1 ? 0 : 1);
        }
    }

    public int solve(int[] source, int[] dest, int[] population) {
        graph = new HashMap<>();
        this.population = population;
        for(int i = 0; i < source.length; i++) {
            graph.putIfAbsent(source[i], new ArrayList<>());
            graph.putIfAbsent(dest[i], new ArrayList<>());

            graph.get(source[i]).add(dest[i]);
            graph.get(dest[i]).add(source[i]);
        }


        dfs(0, -1, 0);
        return Math.max(ans[0], ans[1]);
    }
}
