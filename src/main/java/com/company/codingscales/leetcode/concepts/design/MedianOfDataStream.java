package com.company.codingscales.leetcode.concepts.design;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfDataStream {
    int size;

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianOfDataStream() {
        size = 0;
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(final int num) {
        size++;
        if (maxHeap.isEmpty() || maxHeap.peek() >= num)
            maxHeap.add(num);
        else
            minHeap.add(num);

        // either both the heaps will have equal number of elements or max-heap will have one
        // more element than the min-heap
        if (maxHeap.size() > minHeap.size() + 1)
            minHeap.add(maxHeap.poll());
        else if (maxHeap.size() < minHeap.size())
            maxHeap.add(minHeap.poll());
    }

    public double findMedian() {
        if (size == 0)
            return -1;

        if (size % 2 == 0) {
            final int minPeek = minHeap.peek();
            final int maxPeek = maxHeap.peek();

            return (minPeek + maxPeek) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }
}
