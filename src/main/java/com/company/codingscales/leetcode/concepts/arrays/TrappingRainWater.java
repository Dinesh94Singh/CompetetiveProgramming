package com.company.codingscales.leetcode.concepts.arrays;

import java.util.Stack;

public class TrappingRainWater {
    // for each idx pos, we are pre-cal the right and left boundaries and add res
    public static int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length + 1];

        int N = height.length;

        left[0] = height[0];
        right[N] = height[N - 1];
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
            right[N - i - 1] = Math.max(right[N - i], height[N - i - 1]);
        }

        int ans = 0;
        for (int i = 1; i < N; i++) {
            ans += Math.min(left[i], right[i]) - height[i];
        }

        return ans;
    }

    // We find an Tall Building and remove elements and multiply the distance.
    public static int trapStack(int[] height) {
        int N = height.length;
        if (N == 0)
            return 0;

        Stack<Integer> st = new Stack<>();
        int i = 0;
        int ans = 0;
        while (i < N) {
            int curr = height[i];
            while (!st.isEmpty() && curr > height[st.peek()]) {
                int h = height[st.pop()];

                if (st.isEmpty())
                    break;
                int dist = i - st.peek() - 1;
                ans += (dist * (Math.min(curr, height[st.peek()]) - h));
            }
            st.push(i);
            i++;
        }

        return ans;
    }

    // Left and Right pointers, compare which is a wall.
    // The Smaller one is the wall, which can fit the water.
    // Compare the current val with Smaller wall -> If wall is larger than prev => update it
    // Else, min water we can trap is leftMax - current
    // Similarly, when the min is the rightWall -> Do the same
    public static int trapTwoPointer(int[] A) {
        int left = 0, right = A.length - 1;
        int leftMax = 0, rightMax = 0;
        int ans = 0;
        while (left < right) {
            if (A[left] < A[right]) {
                if (A[left] >= leftMax) {
                    leftMax = A[left];
                } else {
                    ans += (leftMax - A[left]);
                }
                left++;
            } else {
                if (A[right] >= rightMax) {
                    rightMax = A[right];
                } else {
                    ans += (rightMax - A[right]);
                }
                right--;
            }
        }
        return ans;
    }
    public static int trapCummulativeDP(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        int N = height.length;
        if (N == 0)
            return 0;
        left[0] = height[0];
        right[N - 1] = height[N - 1];
        for(int i = 1; i < height.length; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
            right[N - i - 1] = Math.max(right[N - i], height[N - i - 1]);
        }

        int ans = 0;
        for(int i = 1; i < N; i++) {
            ans += Math.min(left[i], right[i]) - height[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
