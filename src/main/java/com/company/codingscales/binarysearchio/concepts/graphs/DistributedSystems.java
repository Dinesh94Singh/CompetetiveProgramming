package com.company.codingscales.binarysearchio.concepts.graphs;

import java.util.*;

// Dijkstra's algorithm
public class DistributedSystems {
    static class Node {
        List<Pair> adjNodes;

        Node() {
            this.adjNodes = new ArrayList<>();
        }
    }

    static class Pair {
        int key;
        int value;

        Pair(int k, int v) {
            key = k;
            value = v;
        }

        int getKey() {
            return this.key;
        }

        int getValue() {
            return this.value;
        }
    }

    // dijkstra's algorithm
    // does min spanning tree guarantee the cost from src to all nodes minimum ?
    public int solve(int n, int[][] edges) {
        HashMap<Integer, Node> graph = new HashMap<>();

        for (int i = 0; i <= n; i++) {
            graph.put(i, new Node());
        }

        for (int[] edge : edges) {
            int src = edge[0];
            int dst = edge[1];
            int cst = edge[2];

            graph.get(src).adjNodes.add(new Pair(dst, cst));
            graph.get(dst).adjNodes.add(new Pair(src, cst));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.value));
        pq.add(new Pair(0, 0));

        boolean[] visited = new boolean[n + 1];

        int maxDist = 0;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            if (visited[p.getKey()])
                continue;

            visited[p.getKey()] = true; // relaxing
            maxDist = Math.max(maxDist, p.getValue());

            for (Pair each : graph.get(p.getKey()).adjNodes) {
                pq.offer(new Pair(each.getKey(), each.getValue() + p.getValue()));
            }
        }

        for (int i = 0; i <= n; i++)
            if (!visited[i])
                return -1;

        return maxDist;
    }

    public static void main(String[] args) {
        DistributedSystems sol = new DistributedSystems();
        int[][] grph = {{0, 1, 2},{0, 2, 3},{0, 3, 5}};
        System.out.println(sol.solve(3, grph));
    }
}
