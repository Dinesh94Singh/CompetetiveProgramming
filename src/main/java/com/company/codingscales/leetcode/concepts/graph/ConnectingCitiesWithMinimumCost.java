package com.company.codingscales.leetcode.concepts.graph;

import java.util.*;

public class ConnectingCitiesWithMinimumCost {
    public class UnionFind {
        int[] parent;
        int[] rank;
        int N;

        UnionFind(final int size) {
            parent = new int[size];
            rank = new int[size];
            N = size;
        }

        private int find(final int c1) {
            if (parent[c1] != c1) {
                this.parent[c1] = find(this.parent[c1]);
            }
            return parent[c1];
        }

        private boolean union(final int c1, final int c2) {
            final int r1 = find(c1);
            final int r2 = find(c2);

            if (r1 == r2) {
                return false;
            }
            N -= 1;
            if (this.rank[r1] == this.rank[r2]) {
                this.parent[r2] = r1;
                this.rank[r1] += 1;
            } else if (this.rank[r1] < this.rank[r2]) {
                this.parent[r1] = r2;
            } else {
                this.parent[r2] = r1;
            }

            return true;
        }
    }

    // UnionFind, DSU, Kruskals
    public int minimumCostKruskals(final int N, final int[][] connections) {
        Arrays.sort(connections, (a, b) -> (a[2] - b[2]));
        final UnionFind uf = new UnionFind(N);
        int res = 0;
        for (final int[] each : connections) {
            final int x = each[0];
            final int y = each[1];

            if (uf.union(x - 1, y - 1)) {
                res += each[2];
            }

            if (uf.N == 1) {
                break;
            }
        }

        return N == 1 ? res : -1;
    }

    // Prim's using Heap
    public int minimumCost(final int n, final int[][] connections) {
        // prims
        final Map<Integer, List<int[]>> graph = new HashMap<>();
        final PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        final Set<Integer> visited = new HashSet<>();
        int costs = 0;

        for (final int[] conn : connections) {
            final int n1 = conn[0];
            final int n2 = conn[1];
            final int cost = conn[2];

            graph.computeIfAbsent(n1, (k) -> new ArrayList<>());
            graph.computeIfAbsent(n2, (k) -> new ArrayList<>());
            graph.get(n1).add(new int[]{n2, cost});
            graph.get(n2).add(new int[]{n1, cost});
        }

        heap.add(new int[]{1, 0});
        while (!heap.isEmpty()) {
            final int[] conn = heap.poll();

            final int curr = conn[0];
            final int cost = conn[1];

            if (!visited.contains(curr)) {
                costs += cost;
                visited.add(curr);
                for (final int[] next : graph.get(curr)) {
                    heap.add(new int[]{next[0], next[1]});
                }
            }
        }

        return visited.size() == n ? costs : -1;
    }
}
