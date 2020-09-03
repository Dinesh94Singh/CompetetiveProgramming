package com.company.codingscales.leetcode.concepts.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

public class CourseSchedule {
    public boolean canFinish(final int n, final int[][] p) {
        final HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        final HashMap<Integer, Integer> inDegree = new HashMap<>();

        for(int i =0; i < n; i++) {
            graph.put(i, new ArrayList<Integer>());
            inDegree.put(i, 0);
        }

        for (final int[] eachPre: p) {
            // 0, 1 -> 1-> 0 map adj list
            final int to = eachPre[0];
            final int from = eachPre[1];

            final int currIncomingNodes = inDegree.get(to);
            inDegree.put(to, currIncomingNodes + 1);

            final ArrayList<Integer> adjList = graph.get(from);
            adjList.add(to);
            graph.put(from, adjList);
        }

        final ArrayDeque<Integer> deque = new ArrayDeque<>();
        for(int i =0; i<n; i++) {
            if (inDegree.get(i) == 0)
                deque.add(i);
        }

        if(deque.isEmpty()) { return false; } // graph lo cycle detection - topological sort is one way to do => dfs/bfs/ disjoint set union
        final ArrayList<Integer> res = new ArrayList<>();
        while(!deque.isEmpty()) {
            final int course = deque.removeLast();
            res.add(course);
            for(final int adjVertex : graph.get(course)) {
                final int currDegree = inDegree.get(adjVertex);
                inDegree.put(adjVertex, currDegree - 1);
                if (inDegree.get(adjVertex) == 0)
                    deque.add(adjVertex);
            }
        }
        return res.size() == n;
    }
}
