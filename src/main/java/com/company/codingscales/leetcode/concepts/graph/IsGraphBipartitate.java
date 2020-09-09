package com.company.codingscales.leetcode.concepts.graph;

import java.util.ArrayDeque;

public class IsGraphBipartitate {
    public static boolean isBipartite(final int[][] input) {
        final int n = input.length;
        final int[] colors = new int[n];
        for(int i = 0; i < n; i++) {
            if (colors[i] != 0) {
                // visited already continue;
                continue;
            }
            colors[i] = 1;
            final ArrayDeque<Integer> dq = new ArrayDeque<>();
            dq.offerLast(i);
            while (!dq.isEmpty()) {
                final int vertex = dq.pollFirst();
                for(final int each : input[vertex]) {
                    if (colors[each] == colors[vertex]) {
                        return false;
                    } else if (colors[each] == 0) {
                        colors[each] = -colors[vertex];
                        dq.offerLast(each);
                    }
                }
            }
        }

        return true;
    }
}
