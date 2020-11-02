package com.company.codingscales.interviews.amazon;

import java.util.*;

// in a review, if a valid keyword appear more than once, it is considered as only 1 occurrence. Sum all the occurrence's of that word in all the reviews
public class TopKFrequentlyMentionedKeywords {
    static List<String> solve(int k, List<String> keywords, List<String> reviews) {
        final List<String> res = new ArrayList<>();
        final HashSet<String> set = new HashSet<>(keywords);
        final HashMap<String, Integer> map = new HashMap<>();

        for(String r : reviews) {
            String[] strs = r.split("\\W");
            Set<String> added = new HashSet<>();
            for(String s : strs) {
                s = s.toLowerCase();
                if(set.contains(s) && !added.contains(s)) {
                    map.put(s, map.getOrDefault(s, 0) + 1);
                    added.add(s);
                }
            }
        }

        // maxHeap based on occr;
        Queue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>((a, b) -> a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
        maxHeap.addAll(map.entrySet());
        while(!maxHeap.isEmpty() && k-- > 0) {
            res.add(maxHeap.poll().getKey());
        }

        return res;
    }

    public static void main(String[] args) {
        List<String> res = solve(2, Arrays.asList("anacell", "cetracular", "betacellular"), Arrays.asList("Anacell provides the best services in the city",
                "betacellular has awesome services",
                "Best services provided by anacell, everyone should use anacell"));
        for(String each : res) {
            System.out.printf("%s \n", each);
        }

        res = solve(2, Arrays.asList("anacell", "betacellular", "cetracular", "deltacellular", "eurocell"), Arrays.asList("I love anacell Best services; Best services provided by anacell",
                "betacellular has great services",
                "deltacellular provides much better services than betacellular",
                "cetracular is worse than anacell",
                "Betacellular is better than deltacellular."
        ));
        for(String each : res) {
            System.out.printf("%s \n", each);
        }
    }
}
