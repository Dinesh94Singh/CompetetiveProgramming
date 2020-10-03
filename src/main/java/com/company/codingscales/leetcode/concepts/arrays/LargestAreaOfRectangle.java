package com.company.codingscales.leetcode.concepts.arrays;

import java.util.ArrayDeque;

public class LargestAreaOfRectangle {
    public static int largestRectangleArea(final int[] heights) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.offerLast(-1);
        int i = 0;

        int maxArea = Integer.MIN_VALUE;
        while (!dq.isEmpty() && i < heights.length) {
            final int curr = heights[i];
            while (dq.peekLast() != -1 && curr <= heights[dq.peekLast()]) {
                int height = heights[dq.pollLast()];
                int prevIndex = dq.peekLast();

                maxArea = Math.max(maxArea, (i - prevIndex - 1) * height);
            }

            dq.offerLast(i++);
        }

        while (!dq.isEmpty() && dq.peekLast() != -1) {
            int height = heights[dq.pollLast()];
            int prevIndex = dq.peekLast();

            maxArea = Math.max(maxArea, (heights.length - prevIndex - 1) * height);
        }

        if (maxArea == Integer.MIN_VALUE)
            return 0;
        return maxArea;
    }
}
