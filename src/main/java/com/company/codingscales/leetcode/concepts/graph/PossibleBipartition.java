package com.company.codingscales.leetcode.concepts.graph;

import com.company.codingscales.templates.LeetCodeInputHelpers;

import java.util.*;

public class PossibleBipartition {
    public boolean possibleBipartition(final int N, final int[][] edges) {
        if (edges.length == 0) {
            return true;
        }

        final Map<Integer, List<Integer>> graph = new HashMap<>();

        for (final int[] edge : edges) {
            graph.putIfAbsent(edge[0] - 1, new ArrayList<Integer>());
            graph.putIfAbsent(edge[1] - 1, new ArrayList<Integer>());

            graph.get(edge[0] - 1).add(edge[1] - 1);
            graph.get(edge[1] - 1).add(edge[0] - 1);
        }

        final int[] colors = new int[N];

        for (int i = 0; i < N; i++) {
            if (colors[i] != 0) {
                continue;
            }

            colors[i] = 1;
            final ArrayDeque<Integer> deque = new ArrayDeque<>();
            deque.add(i);

            while (!deque.isEmpty()) {
                final int vertex = deque.removeFirst();
                for (final int adjVertex : graph.getOrDefault(vertex, new ArrayList<>())) {
                    if (colors[adjVertex] == colors[vertex]) {
                        return false;
                    }

                    if (colors[adjVertex] == 0) { // unvisited
                        colors[adjVertex] = -colors[vertex];
                        deque.addLast(adjVertex);
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PossibleBipartition sol = new PossibleBipartition();
        System.out.println(sol.possibleBipartition(4, LeetCodeInputHelpers.stringToInt2dArray("[[1,2],[1,3],[2,4]]")));
        System.out.println(sol.possibleBipartition(3, LeetCodeInputHelpers.stringToInt2dArray("[[1,2],[1,3],[2,3]]")));
        System.out.println(sol.possibleBipartition(5, LeetCodeInputHelpers.stringToInt2dArray("[[1,2],[3,4],[4,5],[3,5]]")));
        System.out.println(sol.possibleBipartition(4, LeetCodeInputHelpers.stringToInt2dArray("[[1,2],[1,3],[2,4]]")));
    }
}
