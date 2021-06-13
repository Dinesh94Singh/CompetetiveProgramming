package com.company.codingscales.leetcode.concepts.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String each : strs) {
            char[] arr = each.toCharArray();
            Arrays.sort(arr);
            String key2 = Stream.of(arr).map(String::valueOf).collect(Collectors.joining(""));
            String key = Arrays.toString(arr);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(each);
        }

        return new ArrayList<>(map.values());
    }
}
