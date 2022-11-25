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

    public int romanToIntWithOutMapExtension(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        int res = 0;
        int i = 0;

        while (i < s.length()) {
            String curr = s.substring(i, i + 1);
            int currVal = map.get(curr);

            int nxtVal = 0;

            if (i < s.length() - 1) {
                String next = s.substring(i + 1, i + 2);
                nxtVal = map.get(next);
            }

            if (currVal < nxtVal) {
                res += (nxtVal - currVal);
                i+=2;
            } else {
                res += currVal;
                i++;
            }
        }

        return res;
    }
}
