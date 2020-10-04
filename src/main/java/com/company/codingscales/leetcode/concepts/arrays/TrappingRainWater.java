package com.company.codingscales.leetcode.concepts.arrays;

import java.util.Stack;

public class TrappingRainWater {
    public static int trap(final int[] height) {
        Stack<Integer> st = new Stack<>();

        // st.push(-1);

        int i = 0;
        int n = height.length;
        int total = 0;
        while (i < n) {
            int curr = height[i];
            while (!st.isEmpty() && height[st.peek()] < curr) { // when ever u see, water can be trapped, use it.
                int index = st.pop();
                if (st.isEmpty())
                    continue;

                int prevIndex = st.peek();
                int dist = i - prevIndex - 1;
                int minHeight = Math.min(curr, height[prevIndex]);
                total += (minHeight - height[index]) * dist;
            }
            st.push(i);
            i++;
        }

        return total;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}