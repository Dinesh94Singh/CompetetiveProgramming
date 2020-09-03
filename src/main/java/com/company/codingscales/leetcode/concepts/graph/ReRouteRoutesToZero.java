package com.company.codingscales.leetcode.concepts.graph;

import com.company.codingscales.templates.LeetCodeInputHelpers;

import java.util.HashSet;

public class ReRouteRoutesToZero {
    class DisjointSetUnion {
        public int parent[];
        public int rank[];
        public int size;

        DisjointSetUnion(int size) {
            parent = new int[size];
            rank = new int[size];
            this.size = size;

            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        private int find(int c) {
            if (parent[c] != c) {
                parent[c] = find(parent[c]);
            }
            return parent[c];
        }

        /**
         * c1 -> from , c2 -> to
         */
        public boolean union(int c1, int c2) {
            int r1 = find(c1);
            int r2 = find(c2);

            if (r1 == r2) {
                return false;
            }
            this.size--;

            parent[c1] = c2; // parent of c1 is c2

            // if (rank[r1] < rank[r2]) { parent[r1] = r2; }
            // else {
            //     if (rank[r1] == rank[r2]) {
            //         rank[r1]++;
            //     }
            //     parent[r2] = r1;
            // }

            return true;
        }
    }

    public int minReorder(int n, int[][] connections) {
        // union find ?
        DisjointSetUnion uf = new DisjointSetUnion(n);
        for (int[] con : connections) {
            uf.union(con[0], con[1]);
        }


        for (int each : uf.parent)
            System.out.print(each + "\t");

        int count = 0;
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hs.add(uf.find(i));
        }

        return hs.size() + 1;

    }

    public static void main(String[] args) {
        ReRouteRoutesToZero r = new ReRouteRoutesToZero();
        System.out.println(r.minReorder(6, LeetCodeInputHelpers.stringToInt2dArray("[[0,1],[1,3],[2,3],[4,0],[4,5]]")));
    }
}
