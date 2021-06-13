package com.company.codingscales.leetcode.concepts.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupStrings {
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String each : strings) {
            StringBuilder key = new StringBuilder();
            int offset = each.charAt(0) - 'a';

            for(int i = 0; i < each.length(); i++) {
                char ch = (char) (each.charAt(i) - offset);

                if (ch < 'a') {
                    ch += 26;
                }

                key.append(ch);
            }

            map.putIfAbsent(key.toString(), new ArrayList<>());
            map.get(key.toString()).add(each);
        }

        return new ArrayList<>(map.values());
    }
}
