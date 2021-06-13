package com.company.codingscales.leetcode.concepts.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class FindAllAnagramsInAString {
    static class A {
        public void Print() {
            System.out.println("A");
        }
    }
    static class B extends A {
        public void Print() {
            System.out.println("B");
        }
    }

    public static void myPrint(A o) {
        o.Print();
    }

    public static void main(String[] args) {
        System.out.println(10/0);
        A x = new A();
        B y = new B();
        B z = new B();
        myPrint(x);
        myPrint(y);
        myPrint(z);
    }

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


    static class SolutionWithHashMap {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> res = new ArrayList<>();
            int k = p.length();

            HashMap<Character, Integer> pMap = new HashMap<>();
            for(char ch : p.toCharArray())
                pMap.put(ch, pMap.getOrDefault(ch, 0) + 1);

            HashMap<Character, Integer> sMap = new HashMap<>();

            int start = 0;
            for(int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (i < k) {
                    sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
                } else {
                    if (sMap.equals(pMap)) {
                        res.add(start);
                    }

                    char x = s.charAt(start++);

                    if (sMap.get(x) > 1)
                        sMap.put(x, sMap.getOrDefault(x, 1) - 1);
                    else
                        sMap.remove(x);

                    sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
                }
            }

            if (sMap.equals(pMap))
                res.add(start);

            return res;
        }
    }
}
