package com.company.codingscales.leetcode.concepts.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindAllAnagramsInAString {
    private boolean checkEquals(int[] p_arr, int[] s_arr) {
        String p = Arrays.stream(p_arr).mapToObj(String::valueOf).collect(Collectors.joining(","));
        String s = Arrays.stream(s_arr).mapToObj(String::valueOf).collect(Collectors.joining(","));
        System.out.println(p + "\n" + s + "\n\n");
        return p.equals(s);
    }
    public List<Integer> findAnagrams(String s, String p) {
        int[] p_arr = new int[26];
        int[] s_arr = new int[26];
        for(char c: p.toCharArray()) p_arr[(int) c - 97]++;

        for(int i = 0; i < Math.min(s.length(), p.length()); i++) {
            s_arr[(int) s.charAt(i) - 97]++;
        }
        List<Integer> res = new ArrayList<Integer>();
        int start = 0;
        int end;
        for (end = p.length(); end < s.length();) {
            System.out.println(start);
            if (checkEquals(p_arr, s_arr)) { res.add(start); }
            s_arr[(int) s.charAt(start++) - 97]--;
            s_arr[(int) s.charAt(end++) - 97]++;
        }

        if (checkEquals(p_arr, s_arr)) { res.add(start); }

        return res;
    }

    public static void main(String[] args) {
        FindAllAnagramsInAString sol = new FindAllAnagramsInAString();
        // sol.findAnagrams("cbaebabacd", "abc");
        sol.findAnagrams("abab", "ab");

    }
}
