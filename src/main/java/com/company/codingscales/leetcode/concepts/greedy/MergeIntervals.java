package com.company.codingscales.leetcode.concepts.greedy;

public class MergeIntervals {
    /**
     * def merge(self, intervals: List[List[int]]) -> List[List[int]]:
     *         if not intervals:
     *             return []
     *
     *         intervals.sort(key=lambda x: x[0])
     *
     *         interval = intervals[0]
     *         res = []
     *
     *         for idx in range(1, len(intervals)):
     *             other_interval  = intervals[idx]
     *
     *             if interval[1] >= other_interval[0]:
     *                 # they overlap
     *                 interval = [min(interval[0], other_interval[0]),
     *                     max(interval[1], other_interval[1])]
     *             else:
     *                 res.append(interval)
     *                 interval = other_interval
     *
     *         res.append(interval)
     *         return res
     */
}
