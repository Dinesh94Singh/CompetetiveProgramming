package com.company.codingscales.leetcode.concepts.arrays;

import java.util.Stack;

public class BasicCalculator2 {

    // only +, -, *, /
    static void calc(final Stack<Integer> st, final int n, final char ch) {
        if (ch == '+' || ch == '-') {
            st.push(ch == '+' ? n : -n);
        } else if (!st.isEmpty() && (ch == '*' || ch == '/')) {
            final int top = st.pop();
            st.push(ch == '*' ? top * n : top / n);
        }
    }

    public static int calculate(final String s) {
        final Stack<Integer> st = new Stack<>();
        int n = 0;
        int i = 0;
        char sign = '+';

        while (i < s.length()) {
            final char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                n = n * 10 + Character.getNumericValue(ch);
            } else {
                if (ch != ' ') {
                    calc(st, n, sign);
                    sign = ch;
                    n = 0;
                }
            }
            i++;
        }
        calc(st, n, sign);
        return st.stream().reduce(0, Integer::sum);
    }
}
