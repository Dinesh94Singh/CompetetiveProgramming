package com.company.codingscales.leetcode.concepts.strings;

import javafx.util.Pair;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        int n = 0;
        StringBuilder is = new StringBuilder();
        Stack<Pair<Integer, StringBuilder>> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                n = n * 10 + Character.getNumericValue(ch);
            } else if (!(ch == '[' || ch == ']')) {
                is.append(ch);
            } else {
                if (ch == '[') {
                    stack.push(new Pair<>(n, is));

                    n = 0;
                    is = new StringBuilder();
                } else {
                    Pair<Integer, StringBuilder> p = stack.pop();

                    int t = p.getKey();
                    StringBuilder tv = p.getValue();

                    for (int j = 0; j < t; j++) {
                        tv.append(is);
                    }

                    is = tv;
                }
            }
        }

        return is.toString();
    }
}
