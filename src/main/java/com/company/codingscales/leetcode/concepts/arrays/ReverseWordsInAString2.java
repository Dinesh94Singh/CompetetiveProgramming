package com.company.codingscales.leetcode.concepts.arrays;

public class ReverseWordsInAString2 {
    public void reverseWords(char[] s) {
        int i = 0, j = s.length - 1;
        reverse(s, i, j);
        int prev = 0;
        while (i < s.length) {
            while (i < s.length && s[i] != ' ') {
                i++;
            }

            reverse(s, prev, i - 1); // at i, we encounter a " "
            i++;
            prev = i;
        }

        reverse(s, prev, s.length - 1);
    }

    void reverse(char[] s, int i, int j) {
        while (i < j) {
            char t = s[i];
            s[i] = s[j];
            s[j] = t;
            i++;
            j--;
        }
    }
}
