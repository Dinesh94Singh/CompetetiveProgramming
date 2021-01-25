package com.company.codingscales.leetcode.concepts.design;

import java.util.Stack;

// TLE's
public class CustomStackWithIncrement {
    static class CustomStackTLE {
        int top, size, maxsize;
        int[] arr;

        public CustomStackTLE(int maxSize) {
            top = -1;
            arr = new int[maxSize];
            size = 0;
            maxsize = maxSize;
        }

        public void push(int x) {
            if (size != maxsize) {
                arr[++top] = x;
                size++;
            }
        }

        public int pop() {
            if (top == -1)
                return -1;
            size--;
            return arr[top--];
        }

        public void increment(int k, int val) {
            System.out.println("\n Arr so far is ");
            for(int i = size - 1; i >= 0; i--)
                System.out.printf("%d ", arr[i]);

            int[] temp = new int[size];
            int j = 0;
            if (size <= k) {
                for(int t = top; t >= 0; t--, j++) {
                    temp[j] = arr[t] + val;
                }
            } else {
                int N = size - k; // 3 - 2 => 1
                int t = top;
                for(int i = 0; i < N; i++, j++) {
                    temp[j] = arr[t]; // temp[0] = 103
                    t--;
                }

                for(int i = 0; i < k; i++, j++) {
                    temp[j] = arr[t] + val; // temp[]
                    t--;
                }
            }

            int t = 0;
            j = size - 1;
            for(int i = size - 1; i >= 0; i--) {
                arr[t] = temp[j];
                t++;
                j--;
            }

            System.out.print("\n \n Arr later far is :");
            for(int i = size - 1; i >= 0; i--)
                System.out.printf("%d ", arr[i]);
        }
    }

    static class CustomStack {
        int n;
        int[] inc;
        Stack<Integer> stack;
        public CustomStack(int maxSize) {
            n = maxSize;
            inc = new int[n];
            stack = new Stack<>();
        }

        public void push(int x) {
            if (stack.size() < n)
                stack.push(x);
        }

        public int pop() {
            int i = stack.size() - 1;
            if (i < 0)
                return -1;
            if (i > 0)
                inc[i - 1] += inc[i];
            int res = stack.pop() + inc[i];
            inc[i] = 0;
            return res;
        }

        public void increment(int k, int val) {
            int i = Math.min(k, stack.size()) - 1;
            if (i >= 0)
                inc[i] += val;
        }
    }
}
