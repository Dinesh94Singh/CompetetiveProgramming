package com.company.codingscales.templates;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortingBasedOnOtherArray {
    /**
     * Refer to {@link com.company.codingscales.leetcode.concepts.strings.FindAndReplaceInString}
     */
    static void TreeMapSolution() {}
    static class CustomComparator implements Comparator<Integer> {
        private final Map<Integer, Integer> map;
        CustomComparator(Map<Integer, Integer> m) {
            map = m;
        }

        @Override
        public int compare(final Integer curr, final Integer other) {
            if (map.containsKey(curr) && map.containsKey(other))
                return map.get(curr) - map.get(other);
            else if (map.containsKey(other))
                return 1;
            else if (map.containsKey(curr))
                return -1;
            return 0;
        }
    }

    public static void main(String[] args) {
        // Basic solution is use to create a TreeMap, Key is the one which is being sorted, and value is the indexes of the others which needs to be sorted.
        // If the TreeMap doesn't satisfy the sorting needs, then use CustomComparator
        final Integer[] a1 = {1, 2, 3, 4};
        final Integer[] a2 = {10, 9, 5, 20};

        final HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < a1.length; i++){
            hm.put(a1[i], a2[i]);
        }

        Arrays.sort(a2, new CustomComparator(hm)); // adding custom comparator only works with Objects, so primitive int doesn't work
        for(final int each : a2) {
            System.out.print(each + " \t "); // should print in sorted order
        }
    }
}
