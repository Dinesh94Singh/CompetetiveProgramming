package com.company.codingscales.leetcode.concepts.hashmap;

import java.util.*;

public class MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < list1.length; i++) {
            map.putIfAbsent(list1[i], new ArrayList<>());
            map.get(list1[i]).add(i);
        }

        int minDist = Integer.MAX_VALUE;
        HashSet<String> list = new HashSet<>();
        for(int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {

                int dist = Integer.MAX_VALUE;
                for(int each : map.get(list2[i])) { // if it has duplicates.
                    dist = Math.min(dist, Math.abs(each + i));
                }

                if (minDist > dist) {
                    list.clear();
                    list.add(list2[i]);
                    minDist = dist;
                } else if (minDist == dist) {
                    list.add(list2[i]);
                }
            }
        }

        ArrayList<String> al = new ArrayList<>(list);
        String[] res = new String[list.size()];
        for(int i = 0; i < al.size(); i++)
            res[i] = al.get(i);
        return res;
    }
}
