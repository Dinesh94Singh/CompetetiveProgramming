package com.company.codingscales.leetcode.concepts.arrays;

import java.util.Stack;

public class ValidStackSequences {
    public boolean validateStackSequences(final int[] pushed, final int[] popped) {
        final int N = pushed.length;
        final Stack<Integer> stack = new Stack();

        int j = 0;
        for (int x: pushed) {
            stack.push(x);
            while (!stack.isEmpty() && j < N && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }

        return j == N;
    }
}
