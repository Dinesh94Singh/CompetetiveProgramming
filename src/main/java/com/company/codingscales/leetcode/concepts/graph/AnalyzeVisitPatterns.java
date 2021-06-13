package com.company.codingscales.leetcode.concepts.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javafx.util.Pair;

public class AnalyzeVisitPatterns {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        HashMap<String, List<Pair<Integer, String>>> graph = new HashMap<>();
        for (int i = 0; i < username.length; i++) {
            String uname = username[i];
            int ts = timestamp[i];
            String ws = website[i];

            graph.putIfAbsent(uname, new ArrayList<>());
            graph.get(uname).add(new Pair<>(ts, ws));
        }

        HashMap<String, Integer> map = new HashMap<>();

        for (List<Pair<Integer, String>> list : graph.values()) {
            list.sort((a, b) -> {
                return a.getKey() - b.getKey(); // sort based on ts
            });

            HashSet<String> userVisitedPattern = new HashSet<>();

            for (int i = 0; i < list.size() - 2; i++) {
                for (int j = i + 1; j < list.size() - 1; j++) {
                    for (int k = j + 1; k < list.size(); k++) {
                        String sb = list.get(i).getValue() + "," + list.get(j).getValue() + "," + list.get(k).getValue();

                        if (!userVisitedPattern.contains(sb)) {
                            userVisitedPattern.add(sb);
                            map.put(sb, map.getOrDefault(sb, 0) + 1);
                        }
                    }
                }
            }
        }

        int max = 0;
        String key = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (max < entry.getValue()) {
                max = entry.getValue();
                key = entry.getKey();
            } else if (max == entry.getValue() && key.compareTo(entry.getKey()) > 0) {
                key = entry.getKey();
            }
        }

        String[] A = key.split(",");
        return Arrays.stream(A).collect(Collectors.toList());
    }
}