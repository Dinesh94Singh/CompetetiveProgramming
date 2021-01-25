package com.company.codingscales.leetcode.concepts.strings;

import java.util.HashMap;

public class VerifyAnAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> occr = new HashMap<>();
        for(int i = 0; i < order.length(); i++) {
            occr.put(order.charAt(i), i);
        }

        for(int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];

            int j;
            for(j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) == word2.charAt(j))
                    continue;
                if (occr.get(word1.charAt(j)) > occr.get(word2.charAt(j)))
                    return false;
                else {
                    break;
                }
            }

            if (j == word2.length() && j != word1.length())
                return false;
        }

        return true;
    }
}
