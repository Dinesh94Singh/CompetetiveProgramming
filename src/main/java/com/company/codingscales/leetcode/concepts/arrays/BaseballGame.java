package com.company.codingscales.leetcode.concepts.arrays;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class BaseballGame {
    static int calPoints(final String[] ops) {
        final Stack<Integer> st = new Stack<>();
        for(final String each : ops) {
            char ch = each.charAt(0);
            switch (ch) {
                case 'C':
                    if (!st.isEmpty())
                        st.pop();
                    break;
                case 'D':
                    if (!st.isEmpty())
                        st.push(st.peek() * 2);
                    break;
                case '+':
                    int top = st.pop();
                    int nextTop = top + st.peek();

                    st.push(top);
                    st.push(nextTop);
                    break;
                default:
                    st.push(Integer.parseInt(each));
                    break;
            }
        }

        int[][] meetings = new int[10][10];
        String res = Arrays.stream(meetings).map(Arrays::toString).collect(Collectors.joining(","));

        return st.stream().reduce(0, Integer::sum);
    }
}
