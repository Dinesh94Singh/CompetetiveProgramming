package com.company.codingscales.leetcode.concepts.strings;

import java.util.*;

class Solution {
    public int minSteps(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>(); 

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++)
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) -  1);

        int count = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (Math.abs(entry.getValue()) > 0) {
                count += Math.abs(entry.getValue());
            }
        }

        return count / 2;
    }
}