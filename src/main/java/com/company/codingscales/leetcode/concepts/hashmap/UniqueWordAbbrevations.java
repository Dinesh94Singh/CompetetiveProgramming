package com.company.codingscales.leetcode.concepts.hashmap;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class UniqueWordAbbrevations {
    final HashMap<String, Boolean> map = new HashMap<>();
    final HashSet<String> words = new HashSet<>();

    private static String compress(final String word) {
        if (word.length() - 2 <= 0)
            return null;

        StringBuilder sb = new StringBuilder();
        sb.append(word.charAt(0));
        sb.append(word.length() - 2);
        sb.append(word.charAt(word.length() - 1));

        return sb.toString();
    }

    public UniqueWordAbbrevations(final String[] dictionary) {
        Collections.addAll(words, dictionary);

        for(final String each : words) {
            final String compressed = compress(each);
            if (compressed == null) {
            } else if (map.containsKey(compressed)) {
                map.put(compressed, false);
            } else {
                // same abbr is being used for something else
                map.put(compressed, true);
            }
        }
    }

    public boolean isUnique(final String word) {
        final String compressed = compress(word);
        if (compressed == null)
            return true;

        return !map.containsKey(compressed) || (map.get(compressed) && words.contains(word));
    }
}
