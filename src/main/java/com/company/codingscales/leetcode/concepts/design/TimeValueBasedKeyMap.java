package com.company.codingscales.leetcode.concepts.design;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class TimeValueBasedKeyMap {
    HashMap<String, TreeMap<Integer, String>> store;
    public TimeValueBasedKeyMap() {
        store = new HashMap<>();
    }

    public void set(String key, String val, int ts) {
        store.computeIfAbsent(key, (e) -> new TreeMap<>());
        store.get(key).put(ts, val);
    }

    public String get(String key, int ts) {
        if (!store.containsKey(key)) {
            return "";
        }

        Integer closest = store.get(key).floorKey(ts);
        return closest == null ? "" : store.get(key).get(closest);
    }

    private int binarySearch(List<Pair<Integer, String>> list, int ts) {
        int lo = 0, hi = list.size() - 1;
        int res = 0;

        while (lo <= hi) {
            int mid = (lo + (hi - lo) / 2);
            if (list.get(mid).getKey() < ts) { // get the latest
                res = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return res;
    }

    static class SolutionUsingBinarySearchRedo {
        static class Tuple implements Comparable<Tuple> {
            String key;
            String val;
            int ts;

            Tuple(String key, String val, int ts) {
                this.key = key;
                this.val = val;
                this.ts = ts;
            }

            public int compareTo(Tuple other) {
                return this.ts - other.ts;
            }
        }

        HashMap<String, List<Tuple>> map = new HashMap<>();

        public void set(String key, String value, int timestamp) {
            if (map.containsKey(key)) {
                Tuple t = new Tuple(key, value, timestamp);
                map.get(key).add(t);
            } else {
                map.put(key, new ArrayList<>());
                map.get(key).add(new Tuple(key, value, timestamp));
            }
        }

        public String get(String key, int timestamp) {
            if(!map.containsKey(key))
                return "";

            List<Tuple> t = map.get(key);
            // Collections.sort(t);

            int lo = 0, hi = t.size() - 1;
            int idx = 0;
            while (lo <= hi) {
                int mid = (lo + (hi - lo) / 2);

                if (t.get(mid).ts <= timestamp) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }

            if (hi == -1)
                return "";
            return t.get(hi).val;
        }
    }
}
