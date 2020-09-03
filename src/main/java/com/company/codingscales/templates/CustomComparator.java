package com.company.codingscales.templates;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class CustomComparator {
    public static class MyComparator implements Comparator<Map.Entry> {
        @Override
        public int compare(final Map.Entry currEntry, final Map.Entry otherEntry) {
            final Integer curr = (Integer) currEntry.getValue();
            final Integer other = (Integer) otherEntry.getValue();
            System.out.println(curr + " " + other);
            return curr - other;
        }

        @Override
        public boolean equals(final Object o) {
            final Map.Entry curr = ((Map.Entry) this);
            final Map.Entry other = ((Map.Entry) o);

            return curr.getKey() == other.getKey() && curr.getValue() == other.getValue();
        }
    }

    public static void main(final String[] args) {
        final Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 70) ;
        map.put(2, 10);
        map.put(3, 40);

        final List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());

        Collections.sort(entryList, new MyComparator());
        // shorthand notation
        Collections.sort(entryList, (curr, other) -> curr.getValue() - other.getValue());

        for(final Map.Entry<Integer, Integer> entry : entryList) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

//        for(Map.Entry<Integer, Integer> entry : entryList) {
//            System.out.println("Key: " + entry.getKey() + " -> Value: " + entry.getValue());
//        }
    }
}
