package com.company.codingscales.leetcode.concepts.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class EraseOverlappingIntervals {
    class myComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            return a[1] - b[1];
        }
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new myComparator());
        int end = intervals[0][1];
        int count = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                count++; // non-overlapping count
            }
        }
        return intervals.length - count; // you need to remove N - non-overlapping count elements
    }
}
