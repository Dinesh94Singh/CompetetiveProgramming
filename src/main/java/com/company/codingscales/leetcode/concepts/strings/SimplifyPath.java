package com.company.codingscales.leetcode.concepts.strings;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class SimplifyPath {
    private String simplifyPath(final String path) {
        final String[] strings = path.split("\\/", -1);
        final ArrayDeque<String> stack = new ArrayDeque<>();

        for(int i = 1; i < strings.length; i++) {
            final String s = strings[i];
            if (s.equals("") || s.equals(".")) {
            } else if (s.equals("..") && !stack.isEmpty()) {
                stack.removeLast();
            } else if (!s.equals("..")) {
                stack.addLast(s);
            }
        }

        if(stack.isEmpty()) {
            return "/";
        }

        final StringBuilder s = new StringBuilder();
        s.append("/");
        final int n = stack.size();
        for (int i = 0; i < n; i++) {
            s.append(stack.removeFirst());
            if (i != n - 1) {
                s.append("/");
            }
        }
        final String res = s.toString();
        return res;
    }

    public static void main(final String[] args) {
        final SimplifyPath s = new SimplifyPath();
        System.out.println(s.simplifyPath("/home/"));
    }
}
