package com.company.codingscales.contests;

import javafx.util.Pair;

import java.util.Stack;

public class Q2 {
    public int calculate(String s) {
        return helper(0, s).getKey();
    }

    private Pair<Integer, Integer> helper(int i, String s) {
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
                switch(ch) {
                    case '+':
                        sign = '+';
                        break;
                    case '-':
                        sign = '-';
                        break;
                    case '(':
                        Pair<Integer, Integer> p = helper(i, s);
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

        return new Pair<>(st.stream().reduce(0, Integer::sum), s.length());
    }
}
