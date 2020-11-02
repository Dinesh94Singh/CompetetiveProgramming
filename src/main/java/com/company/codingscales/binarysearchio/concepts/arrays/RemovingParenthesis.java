package com.company.codingscales.binarysearchio.concepts.arrays;

import java.util.Stack;

public class RemovingParenthesis {
    public int solve(String s) {
        Stack<Character> st = new Stack<>();
        int count = 0;
        for(char ch : s.toCharArray()) {
            if (ch == '(') {
                st.push('(');
            } else {
                if (st.isEmpty())
                    count++;
                else {
                    st.pop();
                }
            }
        }

        count += st.size();
        return count;
    }
}
