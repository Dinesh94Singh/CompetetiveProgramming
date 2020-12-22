package com.company.codingscales.leetcode.concepts.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class MinimumCostToConnectSticks {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Arrays.stream(sticks).boxed().collect(Collectors.toList()));
        int res = 0;
        while (heap.size() > 1) {
            int t1 = heap.poll();
            int t2 = heap.poll();

            res += (t1 + t2);
            heap.offer(t1 + t2);
        }

        return res;
    }
}
