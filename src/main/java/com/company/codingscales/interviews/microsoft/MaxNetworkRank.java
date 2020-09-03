package com.company.codingscales.interviews.microsoft;

import java.util.HashMap;

public class MaxNetworkRank {
    private static int solve(final int[] A, final int[] B, final int N) {
        final HashMap<Integer, Integer> graph = new HashMap<>();
        for(int i = 0; i < A.length; i++) {
            graph.putIfAbsent(A[i], 0);
            graph.putIfAbsent(B[i], 0);

            graph.put(A[i], graph.get(A[i]) + 1);
            graph.put(B[i], graph.get(B[i]) + 1);
        }

        int maximum = 0;

        for(int i = 0; i < A.length; i++) {
            maximum = Math.max(maximum, graph.get(A[i]) + graph.get(B[i]) - 1);
        }

        return maximum;
    }

    public static void main(final String[] args) {
        System.out.println(solve(new int[] {1, 2, 3, 3}, new int[]{ 2, 3, 1, 4}, 4));
    }
}
