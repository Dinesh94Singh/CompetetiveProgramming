package com.company.codingscales.leetcode.concepts.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import javafx.util.Pair;

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

    public int leastIntervalMyVariant(char[] tasks, int n) {
        if (n == 0)
            return tasks.length;
        HashMap<Character, Integer> counter = new HashMap<>();
        for(char t : tasks)
            counter.put(t, counter.getOrDefault(t, 0) + 1);

        PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        for(Map.Entry<Character, Integer> entry : counter.entrySet()) {
            pq.offer(new Pair<>(entry.getKey(), entry.getValue()));
        }

        int res = 0, k = 0;

        while (!pq.isEmpty()) {
            k = n + 1;
            List<Pair<Character, Integer>> intermediary = new ArrayList<>();
            while (k > 0 && !pq.isEmpty()) {
                Pair<Character, Integer> p = pq.poll();
                res++;
                k--;
                if (p.getValue() > 1) {
                    intermediary.add(new Pair<>(p.getKey(), p.getValue() - 1));
                }
            }

            res += k; // if k == 0, then full-filled all
            pq.addAll(intermediary);
        }

        res -= k; // for the last run, remove the additional steps added

        return res;
    }

    public static void main(String[] args) {
        System.out.println(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2)); // 8
    }
}
