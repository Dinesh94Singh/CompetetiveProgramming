package com.company.codingscales.leetcode.concepts.greedy;

import com.company.codingscales.templates.LeetCodeInputHelpers;

import java.util.Arrays;

public class ConnectingCitiesWithMinimumCost {
    class DisjointSetUnion {
        public int parent[];
        public int rank[];
        public int size;

        DisjointSetUnion(int size) {
            parent = new int[size];
            rank = new int[size];
            this.size = size;

            for(int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        private int find(int c) {
            if (parent[c] != c) { parent[c] = find(parent[c]); }
            return parent[c];
        }

        public boolean union(int c1, int c2) {
            int r1 = find(c1);
            int r2 = find(c2);

            if (r1 == r2) { return false; }
            this.size--;

            if (rank[r1] < rank[r2]) { parent[r1] = r2; }
            else {
                if (rank[r1] == rank[r2]) {
                    rank[r1]++;
                }
                parent[r2] = r1;
            }

            return true;
        }
    }

    public int minimumCost(int N, int[][] connections) {
        DisjointSetUnion dsu = new DisjointSetUnion(N);
        int cost = 0;

        Arrays.sort(connections, (x, y) -> x[2] - y[2]);

        for (int[] edge : connections) {
            if (dsu.size == 0) {
                return cost;
            }
            if (dsu.union(edge[0] - 1, edge[1] - 1)) {
                cost += edge[2];
            }
        }

        return dsu.size != 0 ? -1 : cost;
    }


    public static void main(String[] args) {
        ConnectingCitiesWithMinimumCost sol = new ConnectingCitiesWithMinimumCost();
        System.out.println(sol.minimumCost(3, LeetCodeInputHelpers.stringToInt2dArray("[[1,2,5],[1,3,6],[2,3,1]]")));
        System.out.println(sol.minimumCost(3, LeetCodeInputHelpers.stringToInt2dArray("[[1,2,5],[1,3,6],[2,3,1]]")));
    }
}
