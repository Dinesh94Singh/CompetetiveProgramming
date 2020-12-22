package com.company.codingscales.leetcode.concepts.greedy;

import java.util.PriorityQueue;

public class KthLargestInStream {

    PriorityQueue<Integer> heap;
    int size;

    public KthLargestInStream(int k, int[] nums) {
        size = k;
        heap = new PriorityQueue<>();
        for (int n : nums) {
            if (heap.size() == k) {
                insert(n);
            } else {
                heap.offer(n);
            }
        }


    }


    // if its here, then heap size is already == k
    // check the peek value and compare with n, and decide if needed to replace or not
    void insert(int n) {
        if (heap.peek() < n) {
            heap.poll();
            heap.offer(n);
        }
    }

    public int add(int val) {
        if (heap.size() < size) {
            heap.offer(val);
            return heap.peek();
        }

        insert(val);
        return heap.peek();
    }
}
