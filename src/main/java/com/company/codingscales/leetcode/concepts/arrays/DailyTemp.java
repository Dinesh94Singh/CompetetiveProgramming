package com.company.codingscales.leetcode.concepts.arrays;

import java.util.ArrayDeque;

public class DailyTemp {
    public int[] dailyTemperatures(final int[] T) {
        ArrayDeque<Integer> st = new ArrayDeque<>();

        int i = 0;
        final int[] res = new int[T.length];

        while (i < T.length) {
            while (!st.isEmpty() && T[st.peekLast()] < T[i]) {
                final int index = st.pollLast();
                final int diff = i - index;
                res[index] = diff;
            }

            st.offerLast(i);
            i++;
        }

        return res;
    }
}
