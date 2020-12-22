package com.company.codingscales.interviews.amazon;

import javafx.util.Pair;

import java.util.*;

public class FetchItemsToDisplay {
    public static List<String> fetchItemsToDisplay(int numOfItems, HashMap<String, Pair<Integer, Integer>> items, int sortParameter, int sortOrder, int itemsPerPage, int pageNumber) {

        if (items.isEmpty())
            return Collections.EMPTY_LIST;

        SortedSet<Map.Entry<String, Pair<Integer, Integer>>> set = new TreeSet<>(new Comparator<Map.Entry<String, Pair<Integer, Integer>>>() {
            @Override
            public int compare(Map.Entry<String, Pair<Integer, Integer>> entry1, Map.Entry<String, Pair<Integer, Integer>> entry2) {
                if (sortParameter == 0) {
                    if (sortOrder == 0)
                        return entry1.getKey().compareTo(entry2.getKey());
                    return entry2.getKey().compareTo(entry1.getKey());
                }

                if (sortParameter == 1) {
                    if (sortOrder == 0)
                        return (int) entry1.getValue().getKey() - (int) entry2.getValue().getKey();
                    return (int) entry2.getValue().getKey() - (int) entry1.getValue().getKey();
                }

                if (sortParameter == 2) {
                    if (sortOrder == 0)
                        return (int) entry1.getValue().getValue() - (int) entry2.getValue().getValue();
                    return (int) entry2.getValue().getValue() - (int) entry1.getValue().getValue();
                }
                return 0;
            }
        });

        set.addAll(items.entrySet());

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Pair<Integer, Integer>> entry : set)
            result.add(entry.getKey());

        int start = pageNumber * itemsPerPage;
        int end = (start + itemsPerPage) > result.size() ? result.size() : start + itemsPerPage;

        return result.subList(start, end);
    }

    public static void main(String[] args) {
        int numOfItems = 3;
        HashMap<String, Pair<Integer, Integer>> items = new HashMap<>();
        items.put("item1", new Pair<Integer, Integer>(10, 15));
        items.put("item2", new Pair<Integer, Integer>(3, 4));
        items.put("item3", new Pair<Integer, Integer>(17, 8));

        int sortParameter = 1;
        int sortOrder = 0;
        int itemsPerPage = 2;
        int pageNumber = 1;

        System.out.println(fetchItemsToDisplay(numOfItems, items, sortParameter, sortOrder, itemsPerPage, pageNumber));
    }
}
