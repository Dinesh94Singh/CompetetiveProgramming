package com.company.codingscales.leetcode.concepts.math;


import javafx.util.Pair;

import java.math.BigInteger;
import java.util.HashMap;

public class MaxPointsOnALine {
    int[][] points;
    HashMap<Pair<Integer, Integer>, Integer> lines = new HashMap<>();
    int horizontal = 0, count = 0, N = 0;

    private Pair<Integer, Integer> getSlope(int x1, int x2, int y1, int y2) {
        int dx = x1 - x2;
        int dy = y1 - y2;
        if (dx == 0) {
            return new Pair<>(0,0);
        }
        if (dy == 0) {
            return new Pair<>(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }

        // BigInteger has gcd function
        int gcd = BigInteger.valueOf(dx).gcd(BigInteger.valueOf(dy)).intValue();
        return new Pair<>(dx/gcd, dy/gcd);
    }

    private Pair<Integer, Integer> addLine(int i, int j, int count, int dups) {
        int x1 = points[i][0];
        int y1 = points[i][1];
        int x2 = points[j][0];
        int y2 = points[j][1];

        if ((x1 == x2) && (y1 == y2))
            dups++;
        else if (y1 == y2) {
            horizontal++;
            count = Math.max(horizontal, count);
        } else {
            Pair<Integer, Integer> slope = getSlope(x1, x2, y1, y2);
            lines.put(slope, lines.getOrDefault(slope, 1) + 1);
            count = Math.max(lines.get(slope), count);
        }

        return new Pair<>(count, dups);
    }

    private int dfs(int i) {
        // reset
        lines.clear();
        horizontal = 1;
        int count = 1, duplicates = 0;

        for(int j = i + 1; j < N; j++) {
            Pair<Integer, Integer> p = addLine(i, j, count, duplicates);
            count = p.getKey();
            duplicates = p.getValue();
        }

        return count + duplicates;
    }

    public int maxPoints(int[][] points) {
        this.points = points;
        N = points.length;
        if (N < 3)
            return N;
        int maxCount = 1;
        for(int i = 0; i < N - 1; i++) {
            maxCount = Math.max(dfs(i), maxCount);
        }

        return maxCount;
    }
}
