package com.company.codingscales.leetcode.concepts.strings;

import java.util.HashMap;

public class CanFormPallindrome {
    public boolean canFormPalindrome(final String s) {
        final HashMap<Character, Integer> hm = new HashMap<>();
        for(final char ch: s.toCharArray()) {
            if (Character.isLetter(ch) || Character.isDigit(ch)) {
                hm.putIfAbsent(Character.toLowerCase(ch), 0);
                hm.put(Character.toLowerCase(ch), hm.get(Character.toLowerCase(ch)) + 1);
            }
        }

        boolean oddFound = false;

        for(final Integer v :hm.values()) {
            if ((v & 1) == 1) {
                if (!oddFound) { oddFound = true; }
                else { return false; }
            }
        }

        return true;
    }
}
