package com.company.codingscales.leetcode.concepts.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumNumberOfEventsThatCanBeAttended {
    public int maxEvents(int[][] events) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(events, (a, b) -> (a[0] - b[0])); // based on start times

        int maxDays = Arrays.stream(events).mapToInt(a -> a[1]).max().getAsInt();
        int day = 0;
        int idx = 0;
        int count = 0;

        while (day <= maxDays) {
            while (idx < events.length && events[idx][0] == day) {
                pq.offer(events[idx][1]);
            }

            while (!pq.isEmpty() && pq.peek() < day)
                pq.poll();

            if (!pq.isEmpty()) {
                pq.poll();
                count++;
            }
        }

        return count; // return the events you can attend
    }
}
