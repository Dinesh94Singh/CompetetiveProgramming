package com.company.codingscales.interviews.microsoft;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class MaxLengthOfConcatStringWithNoDuplicateChar {
    static Integer maxLen;
    private static void recHelper(List<String> arr, String s, int index) {
        if(index == arr.size()) {
            maxLen = Math.max(maxLen, s.length());
            if (maxLen == 26)
                System.out.println(s);
            return;
        }

        // Find out - single line code for this
        HashSet<Character> hs = new HashSet<Character>();
        for(char ch: s.toCharArray()) {
            hs.add(ch);
        }

        boolean duplicateFound = false;
        for(char ch: arr.get(index).toCharArray()) {
            if (hs.contains(ch)) {
                duplicateFound = true;
                break;
            }
        }

        if(!duplicateFound) {
            recHelper(arr, s + arr.get(index), index + 1);
        }
        recHelper(arr, s, index + 1);
    }

    public static int maxLength(List<String> arr) {
        maxLen = Integer.MIN_VALUE;
        List<String> al = new ArrayList<>();
        List<String> filteredAl = arr.stream().filter(e -> {
            HashSet<Character> hs = new HashSet<Character>();
            for(char ch: e.toCharArray()) {
                hs.add(ch);
            }
            return hs.size() == e.length();
        }).collect(Collectors.toList());

        recHelper(filteredAl, "", 0);
        return maxLen;
    }

    private static int solution(final String[] arr) {
        return 0;
    }

    public static void main(final String[] args) {
        System.out.println(solution(new String[]{"abc", "def", "ghi", "ijkl"}));
        System.out.println();
        System.out.println(solution(new String[]{"abc", "kkk", "def", "csv"}));
        System.out.println();
        System.out.println(solution(new String[]{"abc", "ade", "akl"}));
        System.out.println();
        System.out.println(solution(new String[]{"co", "dil", "ity"}));
        System.out.println();
    }
}
