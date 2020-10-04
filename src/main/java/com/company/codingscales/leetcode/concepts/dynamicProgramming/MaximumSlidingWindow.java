package com.company.codingscales.leetcode.concepts.dynamicProgramming;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumSlidingWindow {
    public int[] maxSlidingWindowBruteForce(final int[] nums, final int k) {
        // brute force sol is have a window of size k
        int start = 0;
        final int[] res = new int[nums.length - k +  1];

        int o = 0;
        int maximum;

        for(int i = 0; i < nums.length - k + 1; i++) {
            maximum = Integer.MIN_VALUE;
            for(start = i; start < i + k; start++) {
                maximum = Math.max(maximum, nums[start]);
            }
            res[o++] = maximum;
        }


        return res;
    }

    public int[] maxSlidingWindowDP(final int[] nums, final int k) {
        final int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;

        final int [] left = new int[n];
        left[0] = nums[0];
        final int [] right = new int[n];
        right[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            // from left to right
            if (i % k == 0) {
                left[i] = nums[i];  // block_start
            } else {
                left[i] = Math.max(left[i - 1], nums[i]);
            }

            // from right to left
            final int j = n - i - 1;
            if ((j + 1) % k == 0) {
                right[j] = nums[j];  // block_end
            } else {
                right[j] = Math.max(right[j + 1], nums[j]);
            }
        }

        final int [] output = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++)
            output[i] = Math.max(left[i + k - 1], right[i]);

        return output;
    }

    public static int[] slidingWindowMaximumDQ(final int[] nums, int k) {
        final Deque<Integer> deque = new ArrayDeque<>();

        final int length = nums.length;
        final int[] res = new int[length-k+1];
        int j = 0;//for output array
        for(int i = 0; i < length; i++) {

            //while we pass through the array at every step we need to check 2 things
            //1. if a[i] > q.peekLast(), then we poll and add the larger number
            while(!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            //2.if out of range,
            while(!deque.isEmpty() && k < i - deque.peek() + 1) {
                deque.poll();
            }
            //add to the queue
            deque.offer(i);
            //when do we add to the output
            if(i >= k-1) {
                res[j] = nums[deque.peek()];
                j++;
            }
        }
        return  res;
    }
}
