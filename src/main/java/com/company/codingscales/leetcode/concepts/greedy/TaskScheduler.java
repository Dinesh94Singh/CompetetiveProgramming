package com.company.codingscales.leetcode.concepts.greedy;

import javafx.util.Pair;

import java.util.*;

public class TaskScheduler {
    static public int leastInterval(final char[] tasks, final int n) {
        final HashMap<Character, Integer> cntr = new HashMap<>();
        for(final char each : tasks) {
            cntr.putIfAbsent(each, 0);
            cntr.put(each, cntr.get(each) + 1);
        }

        final PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<Pair<Character, Integer>>((p, q) -> q.getValue() - p.getValue());

        for(final Map.Entry<Character, Integer> e : cntr.entrySet()) {
            pq.offer(new Pair<>(e.getKey(), e.getValue()));
        }

        int steps = 0;
        while (!pq.isEmpty()) {
            final List<Pair<Character, Integer>> buffer = new ArrayList<>();
            int k = n + 1;
            while (k > 0 && !pq.isEmpty()) {
                steps++;
                final Pair<Character, Integer> e = pq.poll();
                final int val = e.getValue();
                if (val > 1) {
                    final Pair<Character, Integer> ne = new Pair<>(e.getKey(), val - 1);
                    buffer.add(ne);
                }
                k--;
            }

            for(final Pair<Character, Integer> e : buffer) {
                pq.offer(e);
            }

            if (!pq.isEmpty()) {
                steps += k;
            }
        }

        return steps;
    }

    public static void main(String[] args) {
        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2)); // 8
    }
}
