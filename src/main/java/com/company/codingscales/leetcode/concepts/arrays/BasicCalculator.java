package com.company.codingscales.leetcode.concepts.arrays;

import javafx.util.Pair;

import java.util.Stack;

public class BasicCalculator {
    private static Pair<Integer, Integer> helper(int i, String s) {
        Stack<Integer> st = new Stack<>();
        int n = 0;
        char sign = '+';
        while(i < s.length()) {
            char ch = s.charAt(i);
            if (ch == ' ') {
            } else if (Character.isDigit(ch)) {
                n = n * 10 + Character.getNumericValue(ch);
            } else {
                if (sign == '+')
                    st.push(n);
                else
                    st.push(-n);
                n = 0;
                switch(ch) {
                    case '+':
                        sign = '+';
                        break;
                    case '-':
                        sign = '-';
                        break;
                    case '(':
                        Pair<Integer, Integer> p = helper(i + 1, s);
                        n = p.getKey();
                        i = p.getValue();
                        break;
                    case ')':
                        int total = st.stream().reduce(0, Integer::sum);
                        return new Pair<>(total, i);
                }
            }
            i++;
        }

        st.push(sign == '+' ? n : -n);

        return new Pair<>(st.stream().reduce(0, Integer::sum), s.length());
    }

    public static int calculate(final String s) {
        Pair<Integer, Integer> t = helper(0, s);
        return t.getKey();
    }
}
