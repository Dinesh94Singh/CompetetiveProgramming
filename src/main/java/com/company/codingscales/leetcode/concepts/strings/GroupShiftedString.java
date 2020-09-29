package com.company.codingscales.leetcode.concepts.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupShiftedString {
    public static List<List<String>> groupString(final String[] strings) {
        final HashMap<String, List<String>> map = new HashMap<>();
        for(final String each : strings) {
            final StringBuilder key = new StringBuilder();
            for(int i = 1; i < each.length(); i++) {
                int diff = each.charAt(i) - each.charAt(i - 1);
                // Instead of below, we could do (diff + 26) % 26;
                if (diff < 0)
                    diff += 26;
                key.append(",");
                key.append(diff);
            }

            map.putIfAbsent(key.toString(), new ArrayList<>());
            map.get(key.toString()).add(each);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        groupString(new String[] {"az"});
    }
}
