package com.company.codingscales.leetcode.concepts.strings;

public class StringCompression {
    public static int compress(char[] chars) {
        int i = 0, j = 0;
        int N = chars.length;
        while (i < N) {
            char ch = chars[i];
            int count = 1;
            i++;
            while (i < N && chars[i] == ch) {
                count++;
                i++;
            }

            chars[j] = ch;
            if (count > 1) {
                String s = "" + count;
                for(int k = 0; k < s.length(); k++) {
                    j++;
                    chars[j] = s.charAt(k);
                }
            }
            j++;
        }

        return j;
    }

    public static void main(String[] args) {
        System.out.println(compress(new char[] {'a','a','b','b','c','c','c'}));
        System.out.println(compress(new char[] {'a'}));
        System.out.println(compress(new char[] {'a', 'b', 'c'}));
    }
}
