package com.company.codingscales.leetcode.concepts.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String each : strs) {
            char[] arr = each.toCharArray();
            Arrays.sort(arr);
            String key = Arrays.toString(arr);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(each);
        }

        return new ArrayList<>(map.values());
    }
}
