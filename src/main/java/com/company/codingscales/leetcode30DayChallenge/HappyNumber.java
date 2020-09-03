package com.company.codingscales.leetcode30DayChallenge;

import java.util.HashMap;

public class HappyNumber {
    public static boolean isHappy(int n) {
        final HashMap<Integer, Integer> cache = new HashMap<>();
        int total = 0;
        int i = 0;
        char ch;
        while(true) {
            if (cache.containsKey(n))
                return false;
            total = 0;
            i = 0;
            final String s = String.valueOf(n);
            while(i < s.length()) {
                ch = s.charAt(i);
                total += Math.pow((int) ch - 48, 2);
                i += 1;
            }
            if (total == 1)
                return true;
            cache.put(n, total);
            n = total;
        }
    }

    public static void main(final String[] args) {
        System.out.println(isHappy(19));
    }
}
