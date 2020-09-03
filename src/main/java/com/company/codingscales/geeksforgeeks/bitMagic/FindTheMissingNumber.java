package com.company.codingscales.geeksforgeeks.bitMagic;

public class FindTheMissingNumber {
    public static int findMissingNumber(final int[] arr) {
        int res = 1;
        for(final int a : arr) {
            res ^= a;
        }

        return res;
    }

    public static void main(final String[] args) {
        System.out.println(findMissingNumber(new int[] {1, 3, 5, 2}));
    }
}
