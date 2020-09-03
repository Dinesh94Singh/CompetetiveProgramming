package com.company.codingscales.geeksforgeeks.strings;

public class check2StringsAreRotatedBy2Places {
    private static boolean solve(final String s, final String p) {
        final StringBuilder sb = new StringBuilder(s);
        final String rotatedClockWise = sb.substring(2).concat(sb.substring(0, 2));
        final String rotatedAntiClockWise = sb.substring(s.length() - 2).concat(sb.substring(0, s.length() - 2));

        return p.equals(rotatedAntiClockWise) || p.equals(rotatedClockWise);
    }

    public static void main(final String[] args) {
        final String str1 = "geeks";
        final String str2 = "eksge";

        System.out.println(solve(str1, str2) ?  "Yes" : "No");
    }
}
