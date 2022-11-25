package com.company.codingscales.leetcode.concepts.strings;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static String getPrefix(final String s, final String t) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < Math.min(s.length(), t.length()); i++) {
            if (s.charAt(i) != t.charAt(i))
                break;

            sb.append(s.charAt(i));
        }

        return sb.toString();
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";

        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++) {
            prefix = getPrefix(prefix, strs[i]);
        }

        return prefix;
    }

    // Revised solution
    public String longestCommonPrefixRedo(String[] strs) {
        Arrays.sort(strs, (a, b) -> a.length() - b.length());

        String prefix = strs[0];

        int i = 1;

        while (i < strs.length) {
            String curr = strs[i];
            int j = 0;
            while (j < prefix.length()) {
                if (prefix.charAt(j) == curr.charAt(j)) {
                    j++;
                } else {
                    break;
                }
            }

            prefix = prefix.substring(0, j);

            if (prefix.isEmpty())
                return "";

            i++;
        }

        return prefix;
    }
}
