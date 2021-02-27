package com.company.codingscales.leetcode.concepts.strings;

import java.util.ArrayDeque;

public class RemoveAllAdjDuplicateCharacters {
    public String removeDuplicates(final String S) {
        final ArrayDeque<Character> stack = new ArrayDeque<Character>();

        for (int i = 0; i < S.length(); i++) {
            final char ch = S.charAt(i);
            if (!stack.isEmpty() && stack.peekLast() == ch) {
                while (!stack.isEmpty() && stack.peekLast() == ch) {
                    stack.removeLast();
                }
            } else {
                stack.addLast(ch);
            }
        }

        final StringBuilder sb = new StringBuilder(); // can acutally make use sb as Stack itself
        while(!stack.isEmpty()) {
            sb.append(stack.removeFirst());
        }

        return sb.toString();
    }

    public static void main(final String[] args) {
        final RemoveAllAdjDuplicateCharacters r = new RemoveAllAdjDuplicateCharacters();
        System.out.println(r.removeDuplicates("abbbaca"));
    }
}
