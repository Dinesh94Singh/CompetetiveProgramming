package com.company.codingscales.interviews.microsoft;

import com.company.codingscales.templates.PrintArray;

public class NEqual0 {
    public static int[] sumZero(final int size) {
        final int[] arr = new int[size];
        int start = 0;
        if (size % 2 != 0) {
            arr[0] = 0;
            start += 1;
        }

        int count = 1;
        for (int i = start; i < size; ) {
            arr[i++] = count;
            arr[i++] = -count;
            count += 1;
        }
        return arr;
    }

    public static void main(final String[] args) {
        PrintArray.printArray(sumZero(4));
        PrintArray.printArray(sumZero(5));
        System.out.println(sumZero(5));
    }
}
