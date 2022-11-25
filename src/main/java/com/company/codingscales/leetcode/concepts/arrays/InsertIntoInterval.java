package com.company.codingscales.leetcode.concepts.arrays;

import java.util.ArrayList;
import java.util.List;

public class InsertIntoInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i = 0;

        List<int[]> res = new ArrayList<>();

        while (i < intervals.length && intervals[i][1] < newInterval[0]) { // add prev
            res.add(intervals[i]);
            i++;
        }


        while (i < intervals.length && intervals[i][0] <= newInterval[1] && newInterval[0] <= intervals[i][1]) {  // reached a point where newInterval[0] < curr_ interval[1]

            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);

            i++;
        }

        res.add(newInterval);

        while (i < intervals.length) { // add rest all
            res.add(intervals[i]);
            i++;
        }

        int[][] ans = new int[res.size()][2];
        int d = 0;
        for (int[] each : res) {
            ans[d][0] = each[0];
            ans[d][1] = each[1];

            d++;
        }

        return ans;
    }
}
