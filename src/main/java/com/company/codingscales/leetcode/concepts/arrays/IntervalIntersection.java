package com.company.codingscales.leetcode.concepts.arrays;

import java.util.*;

public class IntervalIntersection {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0, j = 0;

        List<int[]> rl = new ArrayList<>();

        while (i < firstList.length && j < secondList.length) {
            int iStart = firstList[i][0];
            int iEnd = firstList[i][1];

            int jStart = secondList[j][0];
            int jEnd = secondList[j][1];

            if (!((iStart < jStart && jStart > iEnd) || (jStart < iStart && iStart > jEnd)))
                rl.add(new int[] {Math.max(iStart, jStart), Math.min(iEnd, jEnd)});

            if (iEnd < jEnd) {
                i++;
            } else {
                j++;
            }
        }

        int[][] res = new int[rl.size()][2];
        int k = 0;
        for(int[] each : rl) {
            res[k][0] = each[0];
            res[k][1] = each[1];
            k++;
        }

        return res;
    }
}
