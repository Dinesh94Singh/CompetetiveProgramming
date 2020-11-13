package com.company.codingscales.leetcode.concepts.tries;

import java.util.Arrays;
import java.util.HashSet;

public class LongestWordInDictionary {
    public String longestWord(String[] words) {
        HashSet<String> uw = new HashSet<>(Arrays.asList(words));
        Arrays.sort(words, (a, b) -> a.length() == b.length() ? a.compareTo(b) : b.length() - a.length());

        for(String word : words) {
            boolean good = true;
            for(int k = 1; k < word.length(); k++) {
                if (!uw.contains(word.substring(0, k))) {
                    good = false;
                    break;
                }
            }

            if (good)
                return word;
        }

        return "";
    }
}
