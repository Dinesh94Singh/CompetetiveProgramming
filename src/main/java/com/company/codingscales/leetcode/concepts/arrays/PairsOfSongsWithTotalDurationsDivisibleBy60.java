package com.company.codingscales.leetcode.concepts.arrays;

import java.util.HashMap;

public class PairsOfSongsWithTotalDurationsDivisibleBy60 {
    public static int numPairsDivisibleBy60(int[] time) {
        int count = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int e : time) {
            int remainder = e % 60;
            if (hm.containsKey((60 - remainder) % 60)) {
                count += hm.get((60 - remainder) % 60);
            }
            hm.put(remainder, 1 + hm.getOrDefault(remainder, 0));
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40}));
        System.out.println(numPairsDivisibleBy60(new int[]{60, 60, 60}));
    }
}
