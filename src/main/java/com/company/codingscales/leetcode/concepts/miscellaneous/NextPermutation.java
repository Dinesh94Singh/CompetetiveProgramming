package com.company.codingscales.leetcode.concepts.miscellaneous;

import java.util.Arrays;
import java.util.Collections;

public class NextPermutation {
    static void nextPerm(final int[] arr) {
        int i, j;
        for(i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                break;
            }
        }

        for(j = i + 1; j < arr.length; j++) {
            if (arr[i] > arr[j]) { break; }
        }

        j--; // it got incremented once

        swap(arr, i, j);
        reverse(arr, i+1, arr.length - 1);
    }

    static void swap(final int[] arr, final int i, final int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    static void reverse(final int[] arr, int i, int j) {
        while (i <= j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }
}
