package com.company.codingscales.leetcode.concepts.strings;

import java.util.*;

public class FrequencySort {
    public String frequencySort(String s) {
        Map<Character, Integer> hm = new HashMap<>();
        Map<Integer, LinkedHashSet<Character>> reverseMap = new HashMap<>();

        for(char ch : s.toCharArray()) {
            hm.putIfAbsent(ch, 0);
            final int occurence = hm.getOrDefault(ch, 0);

            hm.put(ch, hm.get(ch) + 1);

            if (occurence > 0) {
                reverseMap.get(occurence).remove(ch); // remove the previous entry, since we found a new entry character
            }

            reverseMap.computeIfAbsent(occurence + 1, t -> new LinkedHashSet<Character>()).add(ch);
        }

        Set<Integer> values = new HashSet<Integer>(hm.values());
        List<Integer> sortedValues = new ArrayList<>(values);
        Collections.sort(sortedValues, Comparator.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for(final Integer occurence : sortedValues) {
            for (Character ch : reverseMap.getOrDefault(occurence, new LinkedHashSet<>())) {
                for(int i = 0; i < occurence; i++)
                    sb.append(ch);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        FrequencySort sol = new FrequencySort();
        System.out.println(sol.frequencySort("tree"));
    }
}
