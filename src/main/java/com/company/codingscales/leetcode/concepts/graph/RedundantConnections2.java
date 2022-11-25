package com.company.codingscales.leetcode.concepts.graph;

public class RedundantConnections2 {
    // directed graph

    public static int[] findRedundantDirectedConnection(int[][] edges) {
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] res = findRedundantDirectedConnection(new int[][]{{1,2}, {1,3}, {2,3}});
        System.out.println(res[0] + ", " + res[1]);

        res = findRedundantDirectedConnection(new int[][]{{1,2}, {2,3}, {3,4}, {1,4}, {1, 5}});
        System.out.println(res[0] + ", " + res[1]);

        res = findRedundantDirectedConnection(new int[][]{{2,1},{3,1},{4,2},{1,4}});
        System.out.println(res[0] + ", " + res[1]);
    }
}
