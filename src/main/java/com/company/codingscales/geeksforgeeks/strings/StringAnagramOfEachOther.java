package com.company.codingscales.geeksforgeeks.strings;

public class StringAnagramOfEachOther {
    int[] createArrayMap(final String p) {
        final int[] pArray = new int[256];

        for(final char ch: p.toCharArray())
            pArray[(int) ch] += 1;

        return pArray;
    }

    static boolean isEquals(final int[] arr1, final int[] arr2) {
        for (int i = 0; i < arr1.length; i++)
            if (arr1[i] != arr2[i]) return false;
        return true;
    }

    private boolean solve(final String s, final String p) {
        final int[] sArray = createArrayMap(s);
        final int[] pArray = createArrayMap(p);

        return isEquals(sArray, pArray);
    }

    public static void main(final String[] args) {
        final StringAnagramOfEachOther s = new StringAnagramOfEachOther();
        System.out.println(s.solve("abab", "aabbc"));
    }
}
