package com.company.codingscales.templates;

public class Compare2IntArrays {
    static boolean isEquals(final int[] arr1, final int[] arr2) {
        for (int i = 0; i < arr1.length; i++)
            if (arr1[i] != arr2[i]) return false;
        return true;
    }

    static <T> boolean isEquals(final T[] arr1, final T[] arr2) {
        for(int i = 0; i < arr1.length; i++)
            if (!arr1[i].equals(arr1[i]))
                return false;
        return true;
    }
}
