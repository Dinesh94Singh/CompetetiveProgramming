package com.company.codingscales.leetcode.concepts.strings;

public class RemoveOutermostParenthesis {
    public String removeOuterParentheses(String s) {
        // when level == 0 and '(' or level == 1 and ')' skip adding

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(char ch : s.toCharArray()) {
            if (ch == '(') {
                if (count == 0) {
                } else {
                    sb.append(ch);
                }

                count++;
            } else if (ch == ')') {
                if (count == 1) {
                } else {
                    sb.append(ch);
                }

                count--;
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
