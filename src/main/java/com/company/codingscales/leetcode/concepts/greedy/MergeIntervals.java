package com.company.codingscales.leetcode.concepts.greedy;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            return a[1] - b[1];
        });
        
        int[] interval = intervals[0];
        int i = 0;
        List<int[]> res = new ArrayList<>();
        
        while (i < intervals.length) {
            int[] curr = intervals[i];
            
            int iStart = interval[0];
            int iEnd = interval[1];
            int jStart = curr[0];
            int jEnd = curr[1];
            
            if (iEnd >= jStart) {
                interval[0] = Math.min(iStart, jStart);
                interval[1] = Math.max(iEnd, jEnd);
            } else {
                res.add(new int[]{iStart, iEnd});
                
                interval[0] = jStart;
                interval[1] = jEnd;
            }
            
            i++;
        }
        
        res.add(interval);
        
        int[][] result = new int[res.size()][2];
        int k = 0;
        for(int[] each : res) {
            result[k][0] = each[0];
            result[k][1] = each[1];
            k++;
        }
        
        return result;
    }
}
