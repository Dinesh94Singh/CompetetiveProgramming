package com.company.codingscales.interviews.microsoft;

/**
 * You are given a string SS of length NN containing only characters a and b. A substring (contiguous fragment) of SS
 * is called a semi-alternating substring if it does not contain three identical consecutive characters.
 * In other words, it does not contain either aaa or bbb substrings. Note that whole SS is its own substring.
 *
 * Write a function, which given a string SS, returns the length of the longest semi-alternating substring of SS.
 *
 * Example 1
 * Input: "baaabbabbb"
 * Output: 7
 * Explanation: "aabbabb" is the longest semi-alternating substring.
 * Example 2
 *
 * Input: "babba"
 * Output: 5
 * Explanation: Whole S is semi-alternating.
 * Example 3
 *
 * Input: "abaaaa"
 * Output: 4
 * Explanation: "abaa" is the longest semi-alternating substring.
 */
public class LongestSemiAlteringSubstring {
    public int solve(String s) {
        if (s == null || s.isEmpty()){
            return 0;
        }

        int left = 0;
        int maxlen = 1;
        int count = 1;
        for (int right = 1; right < s.length(); right++){
            char currChar = s.charAt(right);
            char prevChar = s.charAt(right - 1);

            if (currChar == prevChar) {
                count++;
                if (count == 3) {
                    left = right-1;
                    count = 2;
                }
            }else{
                count = 1;
            }
            maxlen = Math.max(maxlen, right-left + 1);
        }

        return maxlen;
    }
}
