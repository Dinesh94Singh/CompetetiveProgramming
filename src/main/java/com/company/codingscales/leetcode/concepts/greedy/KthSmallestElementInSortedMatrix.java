package com.company.codingscales.leetcode.concepts.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementInSortedMatrix {
    static class Node {
        int row;
        int col;
        int val;

        Node(final int row, final int col, final int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    static class MyHeapComparator implements Comparator<Node> {
        @Override
        public int compare(final Node curr, final Node other) {
            return curr.val - other.val;
        }
    }

    public static int kthSmallest(final int[][] matrix, int k) {
        final int N = matrix.length;

        final PriorityQueue<Node> minHeap = new PriorityQueue<Node>(Math.min(N, k), new MyHeapComparator());

        for(int r = 0; r < Math.min(N, k); r++) {
            minHeap.offer(new Node(r, 0, matrix[r][0]));
        }

        Node element = minHeap.peek();

        while(k-- > 0) {
            element = minHeap.poll();
            final int r = element.row;
            final int c = element.col;

            if (c < N - 1)
                minHeap.offer(new Node(r, c + 1, matrix[r][c + 1]));
        }

        return element.val;
    }
}
