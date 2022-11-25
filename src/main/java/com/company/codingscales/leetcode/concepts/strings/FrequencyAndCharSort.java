package com.company.codingscales.leetcode.concepts.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FrequencyAndCharSort {
    public static String solve(String s) {
        StringBuilder res = new StringBuilder();
        HashMap<Character, Integer> counter = new HashMap<>();

        for(char ch : s.toCharArray())
            counter.put(ch, counter.getOrDefault(ch, 0) + 1);

        List<Character> keys = new ArrayList<>(counter.keySet());

        keys.sort((a, b) -> {
            if (counter.get(a) != counter.get(b))
                return counter.get(b) - counter.get(a);
            return a - b;
        });

        for(char ch : keys)
            for(int i = 0; i < counter.get(ch); i++)
                res.append(ch);

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(solve("AAABBAACCCCCBBEED")); // outputs - AAAAACCCCCBBBBEED
    }
}
