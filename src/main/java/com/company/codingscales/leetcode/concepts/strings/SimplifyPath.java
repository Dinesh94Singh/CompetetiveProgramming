package com.company.codingscales.leetcode.concepts.strings;

import java.util.Stack;
import java.util.stream.Collectors;

public class SimplifyPath {
    private String simplifyPath(final String path) {
        path.replace("//", "/");
        String[] elements = path.split("\\/", -1);

        Stack<String> st = new Stack<>();

        for(String each: elements) {
            if (each.equals("") || each.equals(".")) {
                continue;
            } else if (each.equals("..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else {
                st.push(each);
            }
        }

        if (st.isEmpty())
            return "/";

        return "/" + st.stream().collect(Collectors.joining("/"));
    }

    static class SolutionRedo {
        public String simplifyPath(String path) {
            String[] elements = path.split("\\/");

            Stack<String> st = new Stack<>();

            for(String each : elements) {
                if (each.isEmpty()) {
                    continue;
                } else if (each.equals("..")) {
                    if (st.isEmpty()) {
                        continue;
                    }
                    st.pop();
                } else if (each.equals(".")) {
                    continue;
                } else {
                    st.push(each);
                }
            }

            StringBuilder sb = new StringBuilder();

            if (st.isEmpty())
                sb.append("/");

            for(String each : st) {
                sb.append("/");
                sb.append(each);
            }

            return sb.toString();
        }
    }

    public static void main(final String[] args) {
        final SimplifyPath s = new SimplifyPath();
        System.out.println(s.simplifyPath("/home/"));
    }
}
