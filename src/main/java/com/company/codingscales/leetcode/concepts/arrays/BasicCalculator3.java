package com.company.codingscales.leetcode.concepts.arrays;

import java.util.Stack;

public class BasicCalculator3 {
    public static int calculate(final String s) {
        if (s == null) {
            return 0;
        }
        return calc(s + "$", new Stack<>(), 0)[1]; // adding $ so that it goes into the base case and adds the left out num, which was needed to be added in BC1, and BC2 LC problems
    }

    private static int[] calc(final String s, final Stack<Integer> stack, int i) {
        char sign = '+';
        int num = 0;
        while (i < s.length()) {
            final char c = s.charAt(i);
            if (c == ' ') {
                i++;
                continue;
            }
            if (Character.isDigit(c)) {
                num = 10 * num + c - '0';
                i++;
            } else if (c == '(') {
                final int[] v = calc(s, new Stack<>(), i + 1);
                i = v[0];
                num = v[1];
            } else {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                num = 0;
                i++;
                sign = c;
                if (c == ')') {
                    break;
                }
            }
        }

        return new int[] {i, stack.stream().reduce(0, Integer::sum)};
    }

    public static void main(String[] args) {
        System.out.println(calculate("1 + 1"));
    }
}

