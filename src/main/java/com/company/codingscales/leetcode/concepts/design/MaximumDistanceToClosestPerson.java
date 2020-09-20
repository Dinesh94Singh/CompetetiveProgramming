package com.company.codingscales.leetcode.concepts.design;

public class MaximumDistanceToClosestPerson {
    public int maxDistToClosest(final int[] seats) {
        final int n = seats.length;
        int prev = -1;
        int best = 0;
        for(int i = 0; i < n; i++) {
            if (seats[i] == 1) {
                if (prev == -1) {
                    best = i;
                } else {
                    int dist = (i - prev) / 2;
                    if (best < dist) {
                        best = dist;
                    }
                }
                prev = i;
            }
        }

        if (n - prev - 1 > best) {
            best = n - prev - 1;
        }

        return best;
    }
}
