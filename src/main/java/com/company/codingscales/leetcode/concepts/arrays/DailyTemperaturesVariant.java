package com.company.codingscales.leetcode.concepts.arrays;

import javafx.util.Pair;

import java.util.Stack;

public class DailyTemperaturesVariant {
    public static int[] solve(int[] A) {
        Stack<Pair<Integer, Integer>> st = new Stack<>();

        int n = A.length;
        int[] res = new int[n];
        res[0] = 1;
        st.push(new Pair<>(0, -1));

        int i = 1;
        while (i < n) {
            while (!st.isEmpty() && A[st.peek().getKey()] <= A[i]) {
                st.pop();
            }

            int prevIdx = -1;
            if (!st.isEmpty()) {
                prevIdx = st.peek().getKey();
            }

            // System.out.println("for current index " + i + " prev idx is " + prevIdx);

            st.push(new Pair<>(i, i - prevIdx + 1));
            res[i] = i - prevIdx;
            i++;
        }

        return res;
    }
    public static void main(String[] args) {
        int[] res = solve(new int[]{30, 50, 60, 20, 10, 40, 60, 90});
        for(int i = 0; i < res.length; i++)
            System.out.println(res[i]);
    }
}
