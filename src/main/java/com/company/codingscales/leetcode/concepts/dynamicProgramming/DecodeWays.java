package com.company.codingscales.leetcode.concepts.dynamicProgramming;

import java.util.HashMap;

public class DecodeWays {
    private static int recHelper(final int i, final String s) {
        if (i == s.length()) {
            return 1;
        } else if (i > s.length()) {
            return 0;
        }

        final int x = Integer.parseInt(s.substring(i, Math.min(s.length(), i + 2)));

        if (x == 10) {
            return recHelper(i + 2, s);
        } else if (x > 27) {
            return recHelper(i + 1, s);
        }

        return recHelper(i + 1, s) + recHelper(i + 2, s);
    }

    HashMap<Integer, Integer> dp = new HashMap<>();

    private int dfs(int index, String s) {
        if (index >= s.length())
            return 1;

        if (dp.containsKey(index))
            return dp.get(index);

        if (s.charAt(index) == '0')
            return 0;

        int ways = 0;
        ways += dfs(index + 1, s);

        if (index < s.length() - 1) {
            int number = Integer.parseInt(s.substring(index, index + 2));

            if (number >= 10 && number <= 26)
                ways += dfs(index + 2, s);
        }

        dp.put(index, ways);
        return dp.get(index);
    }

    public static int numDecodings(final String s) {
        return recHelper(0, s);
    }

    public static void main(final String[] args) {
        System.out.println(numDecodings("226")); // It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
    }

}
