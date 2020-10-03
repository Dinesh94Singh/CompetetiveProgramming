package com.company.codingscales.leetcode.concepts.strings;

import java.util.HashMap;

public class RomanToInteger {
    public int romanToInt(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int total = 0;
        int i = 0;

        while (i < s.length()) {
            if (i < s.length() - 1 && map.get(s.substring(i + 1, i + 2)) > map.get(s.substring(i, i + 1))) {
                total += map.get(s.substring(i, i + 2));
                i += 2;
            } else {
                total += map.get(s.substring(i, i + 1));
                i+= 1;
            }
        }

        return total;
    }
}
