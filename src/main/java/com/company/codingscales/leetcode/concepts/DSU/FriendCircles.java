package com.company.codingscales.leetcode.concepts.DSU;

import java.util.Arrays;

public class FriendCircles {
    static class DSU {
        int[] parent;
        int[] rank;
        int total;

        DSU(final int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            Arrays.fill(rank, 0);

            total = n;
        }

        int find(final int c) {
            if (parent[c] == c) {
                return parent[c];
            }
            parent[c] = find(parent[c]);
            return parent[c];
        }

        void union(final int c1, final int c2) {
            final int p1 = find(c1);
            final int p2 = find(c2);

            if (p1 == p2) {
                return;
            }
            total--;
            if (rank[p1] > rank[p2]) {
                parent[p2] = p1;
            } else {
                if (rank[p1] < rank[p2]) {
                    parent[p1] = p2;
                } else {
                    parent[p1] = p2;
                    rank[p2]++;
                }
            }
        }
    }
    static public int findCircleNum(final int[][] M) {
        // Given N students in a N*N matrix M
        // A - B (friend), B - C (friend), then A - C (friends)
        // E - F (friend), D - E(friend), then F - D (friends)
        // Total groups 2 (A's group and E's group)

        final int R = M.length;
        final int C = R > 0 ? M[0].length : 0;

//        If the constraint is not giving that there are N students in the matrix, we need to find the count
//        int total = 0;
//        for (final int[] ints : M) {
//            for (int j = 0; j < C; j++) {
//                if (ints[j] == 1) {
//                    total++;
//                }
//            }
//        }

        final DSU dsu = new DSU(R);

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (M[i][j] == 1) {
                    dsu.union(i, j);
                }
            }
        }
        return dsu.total;
    }
}
