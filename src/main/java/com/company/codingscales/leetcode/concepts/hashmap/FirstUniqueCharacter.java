package com.company.codingscales.leetcode.concepts.hashmap;

import java.util.*;

public class FirstUniqueCharacter {
    // LinkedHashMap solution => other languages like c++ can use map, with custom sorting alg which sorts based of the index
    public int firstUniqChar(String s) {
        int index = 0;
        LinkedHashMap<Character, List<Integer>> lhm = new LinkedHashMap<>();
        for (char ch : s.toCharArray()) {
            lhm.putIfAbsent(ch, new ArrayList<>());
            lhm.get(ch).add(index++);
        }
        for (Map.Entry<Character, List<Integer>> entry : lhm.entrySet()) {
            if (entry.getValue().size() == 1) {
                return entry.getValue().get(0);
            }
        }
        return -1;
    }

    public int firstUniqCharUsingHM(String s) {
        int index = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if (hm.containsKey(s.charAt(i))) {
                hm.put(s.charAt(i), -1);
            } else {
                hm.put(s.charAt(i), 1);
            }
        }

        for(int i = 0; i < s.length(); i++) {
            if (hm.getOrDefault(s.charAt(i), 0) == 1)
                return i;
        }
        return -1;
    }
}
