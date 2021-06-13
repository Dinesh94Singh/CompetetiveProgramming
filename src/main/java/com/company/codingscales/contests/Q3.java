package com.company.codingscales.contests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q3 {
    HashMap<String, Boolean> cache = new HashMap<>();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        HashSet<String> wordSet = new HashSet<>(Arrays.asList(words));
        HashSet<String> res = new HashSet<>();
        Arrays.sort(words, (e1, e2) -> e1.length() - e2.length()); // sort as per increasing order

        for(int i = 0; i < words.length; i++) {
            if (words[i].isEmpty())
                continue;
            if (isPossible(words[i], wordSet)) {
                res.add(words[i]);
            }
        }

        return new ArrayList<>(res);
    }

    boolean isPossible(String word, Set<String> words) {
        if (word.equals(""))
            return true;
        if (cache.containsKey(word))
            return cache.get(word);

        for(int i = 1; i < word.length(); i++) {
            String prefix = word.substring(0, i);
            String suffix = word.substring(i);
            System.out.println(prefix + " - " + suffix);
            if (words.contains(word.substring(0, i)) && isPossible(word.substring(i), words)) {
                cache.put(word, true);
                return true;
            } else if (words.contains(word.substring(0, i)) && words.contains(word.substring(i))) {
                cache.put(word, true);
                return true;
            }
        }

        cache.put(word, false);
        return false;
    }

    public static void main(final String[] args) {
        Q3 sol = new Q3();
        System.out.println(sol.findAllConcatenatedWordsInADict(new String[]{"cat", "cats"}));
    }
}
