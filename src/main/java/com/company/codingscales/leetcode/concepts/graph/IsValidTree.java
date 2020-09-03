package com.company.codingscales.leetcode.concepts.graph;

import java.util.Arrays;

class UnionFind {
    int[] parent;
    int[] rank;

    UnionFind(final int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i< size; i++)
            parent[i] = i;

        Arrays.fill(rank, 1);
    }

    int find(final int c) {
        if (parent[c] != c) {
            parent[c] = find(parent[c]);
        }
        return parent[c];
    }

    boolean union(final int c1, final int c2) {
        final int r1;
        int r2 = 0;
        r1 = find(c1);
        r2 = find(c2);

        if (r1 == r2) return false;
        if (rank[r1] > rank[r2]) {
            parent[r2] = r1;
        } else {
            if (rank[r1] == rank[r2]) {
                rank[r2] += 1;
            }
            parent[r1] = r2;
        }
        return true;
    }
}


public class IsValidTree {
    public boolean validTree(final int n, final int[][] edges) {
        // Tree is a graph which doesn't have cycles
        // Cycle detection can be done with topo sort / union find / bfs (or) dfs
        final UnionFind uf = new UnionFind(n);
        for(final int[] eachEdge : edges) {
            if(!uf.union(eachEdge[0], eachEdge[1]))
                return false;
        }

        final int root = uf.find(n - 1);
        for(final int each: uf.parent) {
            if (uf.find(each) != root)
                return false;
        }
        return true;
    }

    public static void main(final String[] args) {
        final IsValidTree isValidTree = new IsValidTree();
        System.out.println(isValidTree.validTree(4, new int[][]{{0,1},{2,3},{1,2}}));
        System.out.println(isValidTree.validTree(4, new int[][]{{0,1},{2,3}}));
    }
}
