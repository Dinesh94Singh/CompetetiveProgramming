package com.company.codingscales.leetcode.concepts.strings;

public class ValidWordAbbreviation {
    public static boolean validWordAbbreviation(String word, String abbr) {
        char[] A = word.toCharArray();
        char[] B = abbr.toCharArray();

        int j = 0;
        int i = 0;

        while (i < A.length && j < B.length) {
            if (!Character.isDigit(B[j])) {
                if (B[j] != A[i])
                    return false;
                i++;
                j++;
            } else {
                int n = 0;
                if (B[j] == '0')
                    return false;

                while (j < B.length && Character.isDigit(B[j])) {
                    n = n * 10 + Character.getNumericValue(B[j]);
                    j++;
                }

                i += n;
            }
        }

        return i == A.length && j == B.length;
    }

    public static void main(String[] args) {
        System.out.println(validWordAbbreviation("internationalization", "i12iz4n"));
        System.out.println(validWordAbbreviation("apple", "a2e"));
    }
}
