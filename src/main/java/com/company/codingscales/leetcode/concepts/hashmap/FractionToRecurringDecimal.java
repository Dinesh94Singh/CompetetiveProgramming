package com.company.codingscales.leetcode.concepts.hashmap;

import java.util.HashMap;

public class FractionToRecurringDecimal {
    // Find the length of longest repeating substring in the decimal part.
    // which would be a dp problem and return that part wrapped in ()

    public String fractionToDecimal(int n, int d) {
        long numerator = (long) n;
        long denominator = (long) d;
        if (numerator == 0)
            return "0";

        final StringBuilder sb = new StringBuilder();
        if (numerator < 0 ^ denominator < 0)
            sb.append("-");

        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);
        long remainder = numerator % denominator;
        if (remainder == 0) {
            sb.append(numerator / denominator);
            return sb.toString();
        }

        sb.append(numerator / denominator);
        sb.append(".");
        final HashMap<String, Integer> map = new HashMap<>();

        while (remainder != 0) {
            final String rem = String.valueOf(remainder);
            if (map.containsKey(rem)) {
                sb.insert(map.get(rem), "(");
                sb.append(")");
                return sb.toString();
            }

            map.put(String.valueOf(remainder), sb.length());
            remainder *= 10;
            sb.append(String.valueOf(remainder / denominator));
            remainder %= denominator;
        }

        return sb.toString();
    }
}
