package com.company.codingscales.leetcode.concepts.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinMeetingRooms2 {
    public static int minMeetingRooms(final int[][] intervals) {
        if (intervals.length == 0) return 0;

        Arrays.sort(intervals, (curr, other) -> curr[0] - other[0]);

        final PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (final int[] interval : intervals) {
            final int interval_start = interval[0];
            final int interval_end = interval[1];

            if (!pq.isEmpty() && pq.peek() <= interval_start) {
                pq.poll();
            }
            pq.add(interval_end);
        }

        return pq.size();
    }

    public static void main(final String[] args) {
        System.out.println(minMeetingRooms(new int[][] {{5, 8}, {6, 8}})); // 2
        System.out.println(minMeetingRooms(new int[][] {{6,15},{13,20},{6,17}})); // 3
    }
}
