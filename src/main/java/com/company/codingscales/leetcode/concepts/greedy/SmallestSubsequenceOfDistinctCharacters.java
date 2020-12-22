package com.company.codingscales.leetcode.concepts.greedy;

import java.util.Stack;

/**
 * Similar to: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
 */

/**
 * You need to include all characters given in string ?
 * you can't always rely on monotonic sequence
 *
 * First Guess, turns out to be **wrong**
 * 		Cache
 *      DP ? Based on index (wrong)
 *
 * Stack & Greedy ? Refer to Lee's solution
 * Find the index of last occurrence for each character.
 * Use a stack to keep the characters for result.
 * Loop on each character in the input string S,
 * if the current character is smaller than the last character in the stack,
 * and the last character exists in the following stream,
 * we can pop the last character to get a smaller result.
 */
public class SmallestSubsequenceOfDistinctCharacters {
    public String smallestSubsequence(String s) {
        int[] lastIdxs = new int[26];
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            lastIdxs[idx] = i;
        }

        int[] visited = new int[26];
        for(int i = 0; i < s.length(); i++) {
            // check if the current char is smaller than previous character of stack
            // check if the previous char's last occurrence is somewhere in future. If not in future, you cannot delete it.
            // You cannot have same character appearing twice, so create a visited arr, and remove / add each time you push and pop the element to stack
            char ch = s.charAt(i);

            if (visited[ch - 'a'] > 0)
                continue;
            while(!st.isEmpty() && Character.compare(st.peek(), ch) >= 0 && lastIdxs[st.peek() - 'a'] > i) {
                char x = st.pop();
                visited[x - 'a'] = 0;
            }

            st.push(ch);
            visited[ch - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(Character ch : st) {
            sb.append(ch);
        }

        return sb.toString();
    }
}
