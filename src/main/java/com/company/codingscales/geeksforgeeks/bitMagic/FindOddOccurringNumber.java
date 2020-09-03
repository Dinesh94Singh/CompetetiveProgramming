package com.company.codingscales.geeksforgeeks.bitMagic;

public class FindOddOccurringNumber {
    public static int findOddOccuringNumber(final int[] arr) {
        int res = 0;
        for(final int a: arr) {
            res ^= a;
        }

        return res;
    }

    public static void main(final String[] args) {
        System.out.println(findOddOccuringNumber(new int[] {1, 1, 2, 2, 3}));
    }
}

