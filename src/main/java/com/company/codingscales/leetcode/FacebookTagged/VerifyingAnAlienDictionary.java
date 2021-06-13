package com.company.codingscales.leetcode.FacebookTagged;

import java.util.HashMap;

public class VerifyingAnAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        for(int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            int j;
            for(j = 0; j < Math.min(w1.length(), w2.length()); i++) {
                if (w1.charAt(j) == w2.charAt(j)) {
                    continue;
                }

                int i1 = map.get(w1.charAt(j));
                int i2 = map.get(w2.charAt(j));

                if (i1 > i2)
                    return false;
            }

            if (j == w2.length() && j != w1.length()) {
                return false;
            }
        }

        return true;
    }
}
