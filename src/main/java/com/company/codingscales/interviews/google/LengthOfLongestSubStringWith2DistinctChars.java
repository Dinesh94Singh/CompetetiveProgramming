package com.company.codingscales.interviews.google;

import java.util.HashMap;

public class LengthOfLongestSubStringWith2DistinctChars {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        int start = 0, end = 0;
        char ch;
        int max = Integer.MIN_VALUE;
        HashMap<Character, Integer> count= new HashMap<>();
        while (end < n) {
            ch = s.charAt(end);
            if (count.size() < 2 || count.containsKey(ch)){
                count.put(ch, count.getOrDefault(ch, 0) + 1);
                end++;
            } else {
                max = Math.max(max, end - start);
                while (start < end) {
                    char startCh = s.charAt(start++);
                    count.put(startCh, count.get(startCh) - 1);
                    if (count.get(startCh) == 0) {
                        count.remove(startCh);
                        break;
                    }
                }
            }
        }

        max = Math.max(max, end - start);
        return max != Integer.MIN_VALUE ? max : 0;
    }

    public static void main(String[] args) {
        LengthOfLongestSubStringWith2DistinctChars sol = new LengthOfLongestSubStringWith2DistinctChars();
        System.out.println(sol.lengthOfLongestSubstringTwoDistinct("abaccc"));
        System.out.println(sol.lengthOfLongestSubstringTwoDistinct("eceba"));
    }
}
