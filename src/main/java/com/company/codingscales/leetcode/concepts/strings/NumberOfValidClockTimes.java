package com.company.codingscales.leetcode.concepts.strings;

/**
 * NumberOfValidClockTimes
 */
public class NumberOfValidClockTimes {

    public int countTime(String time) {
        if (time.equals("??:??")) {
            return 24 * 60;
        }

        int res = 1;

        if (time.charAt(0) == '?' && time.charAt(1) == '?') {
            res *= 24;
        } else if (time.charAt(0) == '?') {
            int v = Character.getNumericValue(time.charAt(1));
            if (v >= 4) {
                res *= 2; // 0 and 1
            } else {
                res *= 3; // 0, 1 and 2
            }
        } else if (time.charAt(1) == '?') {
            int v = Character.getNumericValue(time.charAt(0));

            if (v == 2) { // 20, 21, 22, 23
                res *= 4;
            } else { // 00, 01 ... 10, 11, 12, .... 19
                res *= 10;
            }
        }

        if (time.charAt(3) == '?') {
            // 0, 1, 2, 3, 4, 5
            res *= 6;
        }

        if (time.charAt(4) == '?') {
            // 00, 01, .... 10, 11 .... 20, .... 58, 59
            res *= 10;
        }

        return res;
    }
}
