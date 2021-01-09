package com.company.codingscales.leetcode.concepts.strings;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(char ch : s.toCharArray()) {
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }

        boolean foundOdd = false;
        for(Map.Entry<Character, Integer> entry : hm.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                if (foundOdd) {
                    return false;
                } else {
                    foundOdd = true;
                }
            }
        }

        return true;
    }
}
