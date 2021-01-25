package com.company.codingscales.leetcode.concepts.greedy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;
import java.util.stream.Collectors;

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
        HashMap<Character, Integer> occurences = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            occurences.put(s.charAt(i), i);
        }

        Stack<Character> st = new Stack<>();
        HashSet<Character> visited = new HashSet<>();

        for(int i = 0; i < s.length(); i++) {
            // check if the current char is smaller than previous character of stack
            // check if the previous char's last occurrence is somewhere in future. If not in future, you cannot delete it.
            // You cannot have same character appearing twice, so create a visited arr, and remove / add each time you push and pop the element to stack

            char ch = s.charAt(i);

            if (visited.contains(ch))
                continue;

            while (!st.isEmpty() && st.peek() >= ch && occurences.get(st.peek()) > i) {
                char x = st.pop();
                visited.remove(x);
            }

            st.push(ch);
            visited.add(ch);
        }

        return st.stream().map(String::valueOf).collect(Collectors.joining(""));
    }
}
