package com.company.codingscales.geeksforgeeks.strings;

public class permutationOfStringInAnotherString {
    static boolean isEquals(final int[] arr1, final int[] arr2) {
        for (int i = 0; i < arr1.length; i++)
            if (arr1[i] != arr2[i]) return false;
        return true;
    }

    static boolean solve(final String s, final String p) {
        final int[] sArray = new int[256];
        final int[] pArray = new int[256];

        for(final char ch: p.toCharArray()) {
            final int idx = ch;
            pArray[idx] += 1;
        }

        for(int i = 0; i < s.length(); i++) {
            if (i >= p.length()) {
                if (isEquals(sArray, pArray)) return true;
                final char ch = s.charAt(i - p.length());
                sArray[(int) ch] -= 1;
            }
            sArray[(int) s.charAt(i)] += 1;
        }

        return false;
    }

    public static void main(final String[] args) {
        System.out.println(solve("aabbcde", "ababc"));
    }
}
