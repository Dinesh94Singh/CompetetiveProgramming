package com.company.codingscales.leetcode.concepts.strings;

import java.util.HashMap;

public class LongestAbsoluteFilePath {
    public static int lengthLongestPath(String input) {
        String[] lines = input.split("\\n");
        int maxLength = Integer.MIN_VALUE;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(String s : lines) {
            int level = s.lastIndexOf('\t') + 1;
            int len = s.length() - level;
            if (s.contains(".")) {
                maxLength = Math.max(maxLength, hashMap.get(level) + len);
            } else {
                hashMap.put(level + 1, hashMap.get(level) + len + 1);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "\t\t\t\tfile.txt";
        System.out.println(s.length());
        System.out.println(s.trim().length());
        System.out.println(lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
    }
}
