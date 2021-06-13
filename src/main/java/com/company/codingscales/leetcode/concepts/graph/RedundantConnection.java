package com.company.codingscales.leetcode.concepts.graph;

public class RedundantConnection {
    static class DSU {
        int[] rank;
        int[] parent;

        DSU(int size) {
            rank = new int[size];
            parent = new int[size];

            for(int i = 0; i < size; i++)
                parent[i] = i;
        }

        int find(int c) {
            int p = parent[c];

            if (p != c) {
                parent[c] = find(parent[c]);
            }

            return parent[c];
        }

        boolean union(int c1, int c2) {
            int p1 = find(c1);
            int p2 = find(c2);

            if (p1 == p2)
                return true;

            int r1 = rank[p1];
            int r2 = rank[p2];

            if (r1 < r2) {
                parent[p1] = p2;
            } else {
                if (r1 == r2) {
                   rank[p1]++;
                }

                parent[p2] = p1;
            }

            return false;
        }
    }

    public static int[] findRedundantConnection(int[][] edges) {

        // dsu -> when you find who's parent is same, then it means this edge is redundant
        // what if there are multiple such connections

        DSU dsu = new DSU((int) Math.pow(10, 5));

        for(int[] edge : edges) {
            if (dsu.union(edge[0], edge[1])) {
                return edge;
            }
        }


        return new int[]{-1, -1}; // no redundant connection
    }

    public static void main(String[] args) {
        int[] res = findRedundantConnection(new int[][]{{1,2}, {1,3}, {2,3}});
        System.out.println(res[0] + ", " + res[1]);

        res = findRedundantConnection(new int[][]{{1,2}, {2,3}, {3,4}, {1,4}, {1, 5}});
        System.out.println(res[0] + ", " + res[1]);

        res = findRedundantConnection(new int[][]{{2,1},{3,1},{4,2},{1,4}});
        System.out.println(res[0] + ", " + res[1]);
    }
}
