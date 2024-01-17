package com.company.codingscales.leetcode.concepts.hashmap;

import java.util.*;

public class MinimumNumberOfStepsToMakeTwoStringsAnagram {
    public int minSteps(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
        }

        int required = 0;

        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0) {
                required += entry.getValue();
            }
        }

        return required;
    }
}
