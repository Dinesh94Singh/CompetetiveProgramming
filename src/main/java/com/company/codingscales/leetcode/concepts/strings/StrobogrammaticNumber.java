package com.company.codingscales.leetcode.concepts.strings;

import java.util.HashMap;

public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(6, 9);
        map.put(9, 6);
        map.put(8, 8);
        map.put(0, 0);

        StringBuilder sb = new StringBuilder();
        for (char ch : num.toCharArray()) {
            int x = Character.getNumericValue(ch);
            if (!map.containsKey(x)) { return false; }
            sb.append(map.get(x));
        }

        String t = sb.reverse().toString();
        return num.equals(t);
    }

    public boolean isStrobogrammaticUsing2Pointers(String num) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('6', '9');
        map.put('9', '6');
        map.put('8', '8');
        map.put('1', '1');
        map.put('0', '0');

        int i = 0, j = num.length() - 1;

        while (i <= j) {
            if (!map.containsKey(num.charAt(i)) || (map.get(num.charAt(i)) != num.charAt(j))) {
                return false;
            } else {
                i++;
                j--;
            }
        }

        return true;
    }
}
