package com.company.codingscales.leetcode.concepts.arrays;

import java.util.ArrayDeque;

public class BasicCalculator {
    static class Pair {
        int val;
        int pos;

        Pair(final int val, final int pos) {
            this.val = val;
            this.pos = pos;
        }
    }

    private static Pair helper(final int index, final String s) {
        final ArrayDeque<Integer> st = new ArrayDeque<>();
        int i = index;
        final int N = s.length();

        char sign = '+';
        int n = 0;
        while (i < N) {
            final char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                n = n * 10 + Character.getNumericValue(ch);
            } else if (ch == '+' || ch == '-') {
                if (sign == '+')
                    st.offerLast(n);
                else
                    st.offerLast(n * -1);

                sign = ch;
                n = 0;
            } else if (ch == '('){
                Pair t = helper(i + 1, s);
                if (sign == '+')
                    st.offerLast(t.val);
                else
                    st.offerLast(t.val * -1);

                i = t.pos;
                n = 0;
            } else if (ch == ')') {
                if (sign == '+')
                    st.offerLast(n);
                else
                    st.offerLast(n * -1);

                final int total = st.stream().reduce(0, Integer::sum);
                return new Pair(total, i);
            }

            i++;
        }

        st.offerLast(sign == '+' ? n : -n);

        final int total = st.stream().reduce(0, Integer::sum);
        return new Pair(total, i);
    }

    public static int calculate(final String s) {
        Pair t = helper(0, s);
        return t.val;
    }
}
