package com.company.codingscales.leetcode.concepts.greedy;

import com.company.codingscales.templates.LeetCodeInputHelpers;
import com.company.codingscales.templates.Pair;
import com.company.codingscales.templates.Print2DArray;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {
    private boolean overlap(final int[] interval_A, final int[] interval_B) {
        int aStart = interval_A[0], aEnd = interval_A[1];
        int bStart = interval_B[0], bEnd = interval_B[1];

        // a_start | aEnd | bStart -> no overlap
        // b_start | bEnd | aStart -> no overlap

        final boolean c1 = aStart < bStart && aEnd < bStart;
        final boolean c2 = bStart < aStart && bEnd < aStart;

        if (!(c1 || c2)) {
            return true;
        }

        return false;
    }

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0, j = 0;

        List<Pair<Integer, Integer>> intersecting = new ArrayList<>();

        while (i < A.length && j < B.length) {
            int[] interval_A = A[i];
            int[] interval_B = B[j];

            if (overlap(interval_A, interval_B)) {
                intersecting.add(new Pair<Integer, Integer>(Math.max(interval_A[0], interval_B[0]), Math.min(interval_A[1], interval_B[1])));
            }

            if (interval_B[1] <= interval_A[1]) { j++; }
            else { i++; }
        }

        int[][] res = new int[intersecting.size()][2];
        i = 0;

        for(Pair<Integer, Integer> p : intersecting) {
            res[i][0] = p.u;
            res[i][1] = p.v;

            i++;
        }

        return res;
    }

    public static void main(String[] args) {
        IntervalListIntersections sol = new IntervalListIntersections();
        Print2DArray.printIntArray(sol.intervalIntersection(LeetCodeInputHelpers.stringToInt2dArray("[[0,2],[5,10],[13,23],[24,25]]"), LeetCodeInputHelpers.stringToInt2dArray("[[1,5],[8,12],[15,24],[25,26]]")));
    }
}
