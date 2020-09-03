package com.company.codingscales.leetcode.concepts.strings;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PermutationsInString {
    private boolean isEquals(int[] map1, int[] map2) {
        final String s1 = Arrays.stream(map1).mapToObj(String::valueOf).collect(Collectors.joining(","));
        final String s2 = Arrays.stream(map2).mapToObj(String::valueOf).collect(Collectors.joining(","));

        return s1.equals(s2);
    }

    private boolean helper(String s, int[] map1, int n) {
        int start = 0, end = n;
        int map2[] = new int[26];

        for(int i=0; i < end; i++) {
            char ch = s.charAt(i);
            map2[(int) ch - 97]++;
        }
        char ch;
        while (end < s.length()) {
            if (isEquals(map1, map2)) { return true; }

            ch = s.charAt(start);
            map2[(int) ch - 97]--;
            start++;

            ch = s.charAt(end);
            map2[(int) ch - 97]++;
            end++;
        }

        return isEquals(map1, map2);
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) { return false; }
        int[] map = new int[26];
        for(char c : s1.toCharArray()) {
            map[(int) c - 97]++;
        }
        return helper(s2, map, s1.length());
    }

    public static void main(String[] args) {
        PermutationsInString pis = new PermutationsInString();
        System.out.println(pis.checkInclusion("a", "ab"));
        System.out.println(pis.checkInclusion("ab", "eidbaooo"));
        System.out.println(pis.checkInclusion("adc", "dcda"));
    }
}
