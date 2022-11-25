package com.company.codingscales.leetcode.concepts.arrays;

public class ElementAppearingMoreThan25PercentInSortedArray {
    public int findSpecialInteger(int[] arr) {
        // 25 % => times >= N / 4
        int i = 0;

        while (i < arr.length) {
            int count = 1;
            int v = arr[i];
            while (i < arr.length - 1 && arr[i] == arr[i + 1]) {
                i++;
                count++;
            }

            i++;

            if (count > arr.length / 4)
                return v;
        }

        return -1;
    }
}
