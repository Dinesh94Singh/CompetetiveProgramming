package com.company.codingscales.leetcode.concepts.hashmap;

import java.util.*;
import java.util.stream.Collectors;

public class TweetsInGivenInterval {
    Map<String, TreeMap<Integer, Integer>> tweetNameToTimeToFreq;

    public TweetsInGivenInterval() {
        tweetNameToTimeToFreq = new HashMap<>();
    }

    public void recordTweet(String tweetName, int time) {
        if (!tweetNameToTimeToFreq.containsKey(tweetName))
            tweetNameToTimeToFreq.put(tweetName, new TreeMap<>());
        tweetNameToTimeToFreq.get(tweetName).put(time, tweetNameToTimeToFreq.get(tweetName).getOrDefault(time, 0) + 1);
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        if (!tweetNameToTimeToFreq.containsKey(tweetName))
            return new ArrayList<>();

        TreeMap<Integer, Integer> timeToFreq = tweetNameToTimeToFreq.get(tweetName);
        int interval = 0;
        if (freq.equals("minute")) {
            interval = 60;
        } else if (freq.equals("hour")) {
            interval = 3600;
        } else {
            interval = 3600 * 60;
        }

        int size = (endTime - startTime) / interval + 1;

        int[] buckets = new int[size];

        for(Map.Entry<Integer, Integer> entry : timeToFreq.subMap(startTime, endTime + 1).entrySet()) {
            int idx = (entry.getKey() - startTime) / interval;
            buckets[idx] += entry.getValue();
        }

        return Arrays.stream(buckets).boxed().collect(Collectors.toList());
    }
}
