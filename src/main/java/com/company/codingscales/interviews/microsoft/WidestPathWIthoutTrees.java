package com.company.codingscales.interviews.microsoft;

import java.util.Arrays;

public class WidestPathWIthoutTrees {

    private static int solve(final int[] x, final int[] y) {
        int res = Integer.MIN_VALUE;

        Arrays.sort(x);

        for(int i =0; i<x.length - 1; i++) {
            res = Math.max(res, x[i+1] - x[i]);
        }

        return Math.max(res, 0);
    }

    public static void main(final String[] args) {
        System.out.println(solve(new int[] {5, 5, 5, 7, 7, 7}, new int[] {3, 4, 5, 1, 3, 7}));
    }
}
