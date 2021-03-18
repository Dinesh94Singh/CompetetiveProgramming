package com.company.codingscales.leetcode.concepts.arrays;

import java.util.Stack;

public class RemoveKDigits {
    public static String removeKdigits(String num, int k) {
        char[] A = num.toCharArray();
        int i = 0, N = A.length;
        final Stack<Integer> st = new Stack<>();

        while (i < N) {
            int v = Character.getNumericValue(A[i]);
            while (!st.isEmpty() && st.peek() > v && k > 0) {
                k--;
                st.pop();
            }
            st.push(v);
            i++;
        }

        for (i = 0; i < k; i++) {
            st.pop();
        }

        StringBuilder t = new StringBuilder();
        boolean leadingZero = true;
        for (final int s : st) {
            if (leadingZero && s == 0) {
                continue;
            }
            leadingZero = false;
            t.append(s);
        }

        return t.length() == 0 ? "0" : t.toString();
    }
}
