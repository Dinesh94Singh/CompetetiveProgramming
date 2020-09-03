package com.company.codingscales.interviews.microsoft;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinStepsToMakePilesEqual {
    private static int solve(final int[] arr) {
        final HashMap<Integer, Integer> hm = new HashMap<>();
        for(final int a: arr) {
            hm.putIfAbsent(a, 0);
            hm.put(a, hm.get(a) + 1);
        }

        final Queue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>((curr, other) -> other.getKey() - curr.getKey());
        priorityQueue.addAll(hm.entrySet()); // heapify
        int res = 0;
        while(priorityQueue.size() > 1) {
            final Map.Entry<Integer, Integer> max = priorityQueue.poll();
            final Map.Entry<Integer, Integer> to = priorityQueue.poll();
            res += max.getValue();
            to.setValue(to.getValue() + max.getValue());
            priorityQueue.offer(to);
        }
        return res;
    }
    public static void main(final String[] args) {
        System.out.println(solve(new int[] {5, 2, 1})); // 3
    }
}
