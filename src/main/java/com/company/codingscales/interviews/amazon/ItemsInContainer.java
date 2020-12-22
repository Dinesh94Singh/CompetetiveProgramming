package com.company.codingscales.interviews.amazon;

import java.util.*;

public class ItemsInContainer {
    public static List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {
        int[] left = new int[s.length()];
        int[] right = new int[s.length()];
        int[] asteriks = new int[s.length()];
        List<Integer> numberOfItems = new ArrayList<Integer>();

        if (s == null || s.isEmpty() || s.indexOf('|') == -1 || s.indexOf('*') == -1) {
            return Arrays.asList(0);
        }
        int numberOfAstericks = 0;
        for (int i = 0, j = s.length() - 1; i < s.length(); i++, j--) {
            char l = s.charAt(i);
            char r = s.charAt(j);
            if (l == '|') {
                left[i] = i;
            }
            if (l == '*') {
                numberOfAstericks++;
                left[i] = i == 0 ? 0 : left[i - 1];
            }
            if (r == '*') {
                right[j] = j == s.length() - 1 ? 0 : right[j + 1];
            }
            if (r == '|') {
                right[j] = j;
            }
            asteriks[i] = numberOfAstericks;
        }
        for (int i = 0; i < startIndices.size(); i++) {
            int temp = 0;
            if (startIndices.get(i) <= s.length() && endIndices.get(i) <= s.length()) {
                int start = right[startIndices.get(i) - 1];
                int end = left[endIndices.get(i) - 1];
                temp = start <= end ? 0 : asteriks[end] - asteriks[start];
            }
            numberOfItems.add(temp);
        }
        return numberOfItems;
    }

    public static List<Integer> numberOfItemsNavigableMap(String s, List<Integer> startIndices, List<Integer> endIndices) {
        List<Integer> list = new ArrayList();
        NavigableMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

        int countSoFar = 0;

        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == '|') map.put(i, countSoFar);
            else countSoFar++;

        for (int i = 0; i < startIndices.size(); i++)
            list.add(getItems(map, startIndices.get(i) - 1, endIndices.get(i) - 1));

        return list;
    }

    private static int getItems(NavigableMap<Integer, Integer> map, int start, int end) {
        if (map.floorEntry(end) == null || map.ceilingEntry(start) == null) return 0;
        int items = (int) map.floorEntry(end).getValue() - (int) map.ceilingEntry(start).getValue();
        return Math.max(0, items);
    }

    public static void main(String[] args) {
        String s1 = "|**|*|*";
        System.out.println("Items in " + s1 + " : " + numberOfItems(s1, Arrays.asList(1, 1), Arrays.asList(5, 6))); // Output is [2, 3]

        String s2 = "*|*";
        System.out.println("Items in " + s2 + " : " + numberOfItems(s2, Arrays.asList(0), Arrays.asList(3))); // Output is [0]

        String s3 = "****|*|";
        System.out.println("Items in " + s3 + " : " + numberOfItems(s1, Arrays.asList(0, 4, 2), Arrays.asList(3, 7, 7))); // Output is [0, 1, 1]
    }
}
