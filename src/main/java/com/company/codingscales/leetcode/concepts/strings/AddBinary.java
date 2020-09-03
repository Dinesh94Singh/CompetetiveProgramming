package com.company.codingscales.leetcode.concepts.strings;

public class AddBinary {
    public static String addBinary(final String a, final String b) {
        final int n = a.length();
        final int m = b.length();
        if (n < m) return addBinary(b, a);
        final int L = Math.max(n, m);

        final StringBuilder sb = new StringBuilder();
        int carry = 0, j = m - 1;
        for(int i = L - 1; i > -1; --i) {
            if (a.charAt(i) == '1') ++carry;
            if (j > -1 && b.charAt(j--) == '1') ++carry;

            if (carry % 2 == 1) sb.append('1');
            else sb.append('0');

            carry /= 2;
        }
        if (carry == 1) sb.append('1');
        sb.reverse();

        return sb.toString();
    }

    public static void main(final String[] args) {
        System.out.println(addBinary("1010", "1011"));
    }
}
