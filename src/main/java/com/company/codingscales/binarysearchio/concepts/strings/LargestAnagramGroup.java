package com.company.codingscales.binarysearchio.concepts.strings;

import java.util.HashMap;

public class LargestAnagramGroup {
    public int solve(String[] words) {
        HashMap<String, Integer> hm = new HashMap<>();
        for(String word : words) {
            String key = serialize(word);
            hm.put(key, hm.getOrDefault(key, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        for(int value : hm.values()) {
            max = Math.max(max, value);
        }

        return max;
    }

    private String serialize(String word) {
        int[] arr = new int[26];
        for(char ch : word.toCharArray()) {
            arr[ch - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++) {
            sb.append(arr[i]);
            sb.append("#");
        }

        return sb.toString();
    }
}
