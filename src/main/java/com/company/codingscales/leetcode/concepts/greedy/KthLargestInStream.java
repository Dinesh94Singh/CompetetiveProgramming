package com.company.codingscales.leetcode.concepts.greedy;

import java.util.PriorityQueue;

public class KthLargestInStream {
    PriorityQueue<Integer> pq;
    int k;

    public KthLargestInStream(int k, int[] nums) {
        pq = new PriorityQueue<>(k);
        this.k = k;
        for(int a : nums) {
            if (pq.size() < k) {
                pq.offer(a);
            } else if (pq.peek() < a) {
                pq.poll();
                pq.offer(a);
            }
        }
    }

    public int add(int val) {
        if (pq.size() < k) {
            pq.offer(val);
            return pq.peek();
        } else if (pq.peek() < val) {
            pq.poll();
            pq.offer(val);
            return pq.peek();
        }

        if (pq.isEmpty())
            return -1;
        return pq.peek();
    }
}
