package com.company.codingscales.interviews;

import java.util.ArrayDeque;
import java.util.Deque;

public class FindMaximumOfMinimumElementOfWindowSizeK {
    static int findMaximumOfMinumumElementOfWindowSizeK(final int[] nums, final int k) {
        Deque<Integer> deque = new ArrayDeque<>();

        int length = nums.length;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {

            //while we pass through the array at every step we need to check 2 things
            //1. if a[i] > q.peekLast(), then we poll and add the larger number
            while (!deque.isEmpty() && nums[i] < nums[deque.peekLast()]) {
                deque.pollLast();
            }
            //2.if out of range,
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            //add to the queue
            deque.offer(i);
            //when do we add to the output
            if (i >= k - 1) {
                res = Math.max(res, nums[deque.peek()]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        final int[] arr = {10, 20, 30, 50, 10, 70, 30};
        System.out.println(findMaximumOfMinumumElementOfWindowSizeK(arr, 2)); // 30
        System.out.println(findMaximumOfMinumumElementOfWindowSizeK(arr, 1)); // 70
        System.out.println(findMaximumOfMinumumElementOfWindowSizeK(arr, 4)); // 10
    }
}
