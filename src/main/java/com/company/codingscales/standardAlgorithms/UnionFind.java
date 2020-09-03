package com.company.codingscales.standardAlgorithms;

import java.util.HashMap;

public class UnionFind {
    int[] parent;
    int[] rank;

    public UnionFind(final int size) {
        parent = new int[size];
        rank = new int[size];
    }

    public int find(final int c1) {
        final HashMap<Integer, Integer> hm = new HashMap<>();
        final Integer[] keys = (Integer [])hm.keySet().toArray();
        if(parent[c1] != c1) {
            this.parent[c1] = find(this.parent[c1]);
        }
        return parent[c1];
    }

    public void union(final int c1, final int c2) {
        final int r1 = find(c1);
        final int r2 = find(c2);

        if(r1 == r2) { return; }
        if(this.rank[r1] == this.rank[r2]) {
            this.parent[r2] = r1;
            this.rank[r1] += 1;
        } else if(this.rank[r1] < this.rank[r2]) {
            this.parent[r1] = r2;
        } else {
            this.parent[r2] = r1;
        }
    }
}
