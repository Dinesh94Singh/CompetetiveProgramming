package com.company.codingscales.interviews.amazon;

import java.util.ArrayList;
import java.util.List;

// Optimal Utilization

/**
 * {@link com.company.codingscales.leetcode.concepts.arrays.TwoSumLessThanK}
 */
public class PrimeAirRoutes {
    private List<int[]> getPairs(List<int[]> a, List<int[]> b, int target) {
        // 0th element, represents an ID
        // 1st element, represents an Value

        a.sort((i, j) -> i[1] - j[1]);
        b.sort((i, j) -> i[1] - j[1]);

        int max = Integer.MIN_VALUE;
        int M = a.size();
        int N = b.size();

        int i = 0, j = N - 1;
        List<int[]> res = new ArrayList<>();

        while (i < M && j >= 0) {
            int total = a.get(i)[1] + b.get(j)[1];
            if (total > target) {
                j--;
            } else {
                if (max <= total) {
                    if (max < total) {
                        max = total;
                        res.clear(); // remove all the old values.
                    }
                    res.add(new int[]{a.get(i)[0], b.get(j)[0]});
                    int idx = j - 1;
                    while (idx >= 0 && b.get(idx)[1] == b.get(idx + 1)[1]) { // find duplicates
                        res.add(new int[]{a.get(i)[0], b.get(i)[0]});
                    }
                }
                i++;
            }
        }

        return res;
    }
}
