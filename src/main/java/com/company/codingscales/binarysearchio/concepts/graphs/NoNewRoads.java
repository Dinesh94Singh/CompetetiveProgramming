package com.company.codingscales.binarysearchio.concepts.graphs;

import java.util.HashMap;
import java.util.HashSet;

public class NoNewRoads {
    public boolean solve(int n, int[][] friends) {
        HashMap<Integer, HashSet<Integer>> grph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            grph.put(i, new HashSet<>());
        }

        for (int[] each : friends) {
            grph.get(each[0]).add(each[1]);
            grph.get(each[1]).add(each[0]);
        }

        for (HashSet<Integer> value : grph.values()) {
            if (value.isEmpty())
                return false;
        }

        return true;
    }
}
