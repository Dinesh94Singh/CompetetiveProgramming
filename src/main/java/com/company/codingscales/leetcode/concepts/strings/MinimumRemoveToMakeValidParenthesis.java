package com.company.codingscales.leetcode.concepts.strings;

public class MinimumRemoveToMakeValidParenthesis {
    public String minRemoveToMakeValid(String s) {
        char[] A = s.toCharArray();
        int open = 0, additionalOpen = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < A.length; i++) {
            if (A[i] == '(') {
                open++;
                additionalOpen++;
                sb.append(A[i]);
            } else if (additionalOpen > 0 && A[i] == ')') {
                additionalOpen--;
                sb.append(A[i]);
            } else if (A[i] != '(' && A[i] != ')'){
                sb.append(A[i]);
            }
        }

        int required = open - additionalOpen;
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(' && required > 0) {
                required--;
                res.append(sb.charAt(i));
            } else if (sb.charAt(i) != '(') {
                res.append(sb.charAt(i));
            }
        }

        return res.toString();
    }
}
