package com.company.codingscales.leetcode.concepts.strings;

public class AtoI {
    public static int myAtoi(String str) {
        str = str.trim(); // trims all leading spaces

        if (str.isEmpty()) { return 0; }

        final String[] words = str.split(" ");
        final char ch = words[0].charAt(0);
        int start = 0, sign = 1;

        if (!Character.isDigit(ch) && ch != '+' && ch != '-'){
            return 0;
        }

        if (ch == '+' || ch == '-') {
            start = 1;
            sign = ch == '+' ? 1 : -1;
        }

        double value = 0;

        for(final char chr : words[0].substring(start).toCharArray()) {
            if (!Character.isDigit(chr)) { return 0; }
            if (value == Integer.MIN_VALUE) { return Integer.MIN_VALUE; }
            if (value == Integer.MAX_VALUE) { return Integer.MAX_VALUE; }

            System.out.println(value);

            value = value * 10 + (int) chr - 48;

        }

        System.out.println("Sign" + sign);
        System.out.println(value);
        value = value * sign;

        if (value >= Integer.MAX_VALUE) { return Integer.MAX_VALUE; }
        if (value <= Integer.MIN_VALUE) { return Integer.MIN_VALUE; }

        return (int) value;
    }

    public static void main(final String[] args) {
        // System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("9223372036854775808"));
    }
}
