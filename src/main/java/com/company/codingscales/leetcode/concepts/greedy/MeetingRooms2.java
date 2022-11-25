package com.company.codingscales.leetcode.concepts.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms2 {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0)
            return 0;

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }

            return a[1] - b[1];
        });

        PriorityQueue<int[]> pq = new PriorityQueue<>((interval1, interval2) -> {
            // return the interval, which ends first.
            return interval1[1] - interval2[1];
        });



        pq.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] top = pq.peek();
            if (overlap(top, intervals[i])) {
                pq.offer(intervals[i]);
            } else {
                pq.poll();
                pq.offer(intervals[i]);
            }
        }

        return pq.size();
    }

    private boolean overlap(int[] A, int[] B) {
        /**
         *
         * Sorted
         *
         *  A
         *  |---------|
         *     |------------|
         *     B
         *
         *  A
         *  |-----------|
         *      |---|
         *      B
         */

        if (A[1] > B[0]) {
            return true;
        }

        return false;
    }
}
