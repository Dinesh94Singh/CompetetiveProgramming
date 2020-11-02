package com.company.codingscales.binarysearchio.concepts.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

// didn't wrk
public class MinimumSpanningTree {
    public boolean solve(int[][] edges, int a, int b) {
        HashMap<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] edge : edges) {
            int src = edge[0];
            int dst = edge[1];
            int cost = edge[2];

            graph.putIfAbsent(src, new ArrayList<>());
            // graph.putIfAbsent(dst, new ArrayList<>());
            graph.get(src).add(new int[]{dst, cost});
            // graph.get(dst).add(new int[]{src, cost});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((e1, e2) -> Integer.compare(e1[1], e2[1]));

        pq.offer(new int[]{0, 0, -1});
        boolean[] visited = new boolean[edges.length];

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int src = curr[0];

            int cost = curr[1];
            int prev = curr[2];

            if (src == b && prev == a)
                return true;

            prev = src;

            for (int[] ar : graph.getOrDefault(src, new ArrayList<>())) {
                if (visited[ar[0]]) {
                    continue;
                }

                pq.offer(new int[]{ar[0], cost + ar[1], src});
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] edges = {
                {0, 1, 1},
                {0, 2, 1},
                {1, 2, 2}
        };
        int a = 0;
        int b = 1;

        MinimumSpanningTree mst = new MinimumSpanningTree();
        mst.solve(edges, a, b);
    }
}
