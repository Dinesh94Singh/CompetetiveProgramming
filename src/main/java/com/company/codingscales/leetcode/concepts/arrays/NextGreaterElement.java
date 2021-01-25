package com.company.codingscales.leetcode.concepts.arrays;

import java.util.*;

public class NextGreaterElement {
    public int[] nextGreaterElements(int[] nums) {
        if (nums.length == 0)
            return new int[]{};
        Stack<Integer> st = new Stack<>();
        int n = nums.length;

        int[] res = new int[n];
        Arrays.fill(res, -1);
        int i = 0;

        while (i < n) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                int idx = st.pop();
                res[idx] = nums[i];
            }
            st.push(i);
            i++;
        }

        if (st.isEmpty())
            return res;

        i = 0;
        while (i < st.peek()) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                int idx = st.pop();
                res[idx] = nums[i];
            }
            i++;
        }

        return res;
    }
}
