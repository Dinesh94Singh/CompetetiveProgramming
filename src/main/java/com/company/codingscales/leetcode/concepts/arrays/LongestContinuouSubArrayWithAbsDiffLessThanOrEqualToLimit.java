package com.company.codingscales.leetcode.concepts.arrays;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestContinuouSubArrayWithAbsDiffLessThanOrEqualToLimit {
    /**
     * window can have a maximum and minimum -> how to keep track of next minimum -> for better tc., instead of finding it again in subwindow.
     * O(n) solution is to use deque one for minimum tracking and other for maximum tracking.
     * when we increment the start, and that is the prev min, we need to find the new min => We shouldn't search the subwindow again
     * similarly if we increment the start and that is the prev max, we need to find the new max => We shouldn't search the subwindow again
     * [2 5] , if you encounter a 1 => deque becomes [1] // storing the indices
     * [5, 2], if you encounter a 8 => deque becomes [8] // storing the indices
     *
     * MinDeque [2, 5], if you encounter a 3 => deque becomes [2, 3]
     * MaxDeque [5, 2], if you encounter a 3 => deque becomes [5, 3]
     */
    static int longestSubarray(final int[] A, final int limit) {
        final Deque<Integer> maxd = new ArrayDeque<>();
        final Deque<Integer> mind = new ArrayDeque<>();
        int i = 0, j;
        for (j = 0; j < A.length; ++j) {
            while (!maxd.isEmpty() && A[j] > maxd.peekLast()) maxd.pollLast();
            while (!mind.isEmpty() && A[j] < mind.peekLast()) mind.pollLast();
            maxd.add(A[j]);
            mind.add(A[j]);
            if (maxd.peek() - mind.peek() > limit) {
                if (maxd.peek() == A[i]) maxd.poll();
                if (mind.peek() == A[i]) mind.poll();
                ++i;
            }
        }
        return j - i;
    }
}
