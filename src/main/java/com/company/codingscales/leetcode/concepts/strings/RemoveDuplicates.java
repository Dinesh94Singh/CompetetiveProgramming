package com.company.codingscales.leetcode.concepts.strings;

import java.util.Stack;

public class RemoveDuplicates {
    public String removeDuplicates(String s, int k) {
        // using stack
        char[] arr = s.toCharArray();
        int i = 0, j = 0;
        Stack<Integer> st = new Stack<>();
        while (i < arr.length) {
            arr[j] = arr[i];
            if (j == 0 || arr[j] != arr[j - 1]) {
                st.push(1); // push the count to st
            } else {
                int temp = st.pop() + 1;
                if (temp == k)
                    j = j - k;
                else
                    st.push(temp);
            }
            i++;
            j++;
        }
        return new String(arr, 0, j);
    }
}
