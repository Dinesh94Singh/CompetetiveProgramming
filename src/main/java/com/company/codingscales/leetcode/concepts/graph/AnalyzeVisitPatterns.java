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
        // pattern is always 3 words
        // if user a visits 6 webpages - all possibilties should be used
        
        int n = username.length;
        HashMap<String, List<Pair<Integer, String>>> map = new HashMap<>();
            
        for (int i = 0; i < n; i++) {
            String name = username[i];
            int ts = timestamp[i];
            String ws = website[i];
            
            
            map.putIfAbsent(name, new ArrayList<>());
            map.get(name).add(new Pair<>(ts, ws));
        }
        
        HashMap<String, Integer> counter = new HashMap<>();
        
        for (String key : map.keySet()) {
            List<Pair<Integer, String>> list = map.get(key);
            HashSet<String> seen = new HashSet<>();
            
            list.sort((a,b) -> {
                return a.getKey() - b.getKey(); 
            });
            
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    for (int k = j + 1; k < list.size(); k++) {
                        String pattern = list.get(i).getValue() + "#" + list.get(j).getValue() + "#" + list.get(k).getValue();
                        
                        if (!seen.contains(pattern)) {
                            // user can visit the pattern only once
                            counter.put(pattern, counter.getOrDefault(pattern, 0) + 1);
                            seen.add(pattern);
                        }
                    }
                }
            }
        }
        
        int best_val = 0;
        String res = "";
        for (Map.Entry<String, Integer> entry : counter.entrySet()) {
            if (entry.getValue() > best_val) {
                res = entry.getKey();
                best_val = entry.getValue();
            } else if (entry.getValue() == best_val) {
                int cmp = res.compareTo(entry.getKey());
                
                if (cmp > 0) {
                    res = entry.getKey();
                }
            }
        }
        
        if (best_val == 0)
            return new ArrayList<>();
        return Arrays.stream(res.split("#")).collect(Collectors.toList());
    }
}