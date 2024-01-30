package com.company.codingscales.leetcode.concepts.graph;

import java.util.*;

/**
 * TheEarliestMomentEveryOneBecomesFriends
 */
public class TheEarliestMomentEveryOneBecomesFriends {

    class DSU {
        int[] parent;
        int[] rank;
        int N;
        int total;

        DSU(int n) {
            N = n;
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }

            total = n;
        }

        int find(int c) {
            if (c != parent[c]) {
                parent[c] = find(parent[c]);
            }

            return parent[c];
        }

        void union(int c1, int c2) {
            int p1 = find(c1);
            int p2 = find(c2);

            if (p1 == p2) { // already belonging to same set
                return;
            }

            total--;

            if (rank[p1] < rank[p2]) {
                rank[p2]++;
                parent[p1] = p2;
            } else {
                rank[p1]++;
                parent[p2] = p1;
            }
        }
    }

    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (a, b) -> a[0] - b[0]);
        DSU dsu = new DSU(n);

        for (int[] log : logs) {
            int ts = log[0];
            int start = log[1];
            int end = log[2];

            dsu.union(start, end);

            if (dsu.total == 1) {
                return ts;
            }
        }

        return -1;
    }
}
