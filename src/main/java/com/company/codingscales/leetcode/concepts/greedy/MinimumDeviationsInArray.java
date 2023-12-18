package com.company.codingscales.leetcode.concepts.greedy;

import java.util.Collections;

import java.util.*;

/**
 * You can modify each element
 * if element is odd - element * 2
 * if element is even - element / 2
 * 
 * Find the minimum deviation where deviation = difference between two elements
 * 
 * Eg: [1,2,3,4]
 * [1,2,3,4] -> [2,2,6,4] ->
 */
public class MinimumDeviationsInArray {
    // Using PriorityQueue
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        int minimumDeviation = Integer.MAX_VALUE;

        int minimumValue = Integer.MAX_VALUE;
        // maximize the array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                int t = nums[i] * 2;
                maxQ.offer(t);
                minimumValue = Math.min(minimumValue, t);
            } else {
                maxQ.offer(nums[i]);
                minimumValue = Math.min(minimumValue, nums[i]);
            }
        }

        while (!maxQ.isEmpty()) {
            int top = maxQ.poll();
            minimumDeviation = Math.min(minimumDeviation, top - minimumValue);

            if (top % 2 != 0) {
                break;
            }

            maxQ.offer(top / 2);
            minimumValue = top / 2;
        }

        return minimumDeviation;
    }

    public static void main(String[] args) {
        MinimumDeviationsInArray s = new MinimumDeviationsInArray();
        int[] A = new int[] { 4, 3, 1, 8 };

        int res = s.minimumDeviation(A);
        System.out.println(Arrays.toString(A) + " -> " + res);
    }
}
