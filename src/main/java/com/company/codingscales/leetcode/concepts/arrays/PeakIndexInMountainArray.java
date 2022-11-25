package com.company.codingscales.leetcode.concepts.arrays;

public class PeakIndexInMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int i = 0;

        while (i < arr.length - 1 && arr[i] < arr[i + 1]) {
            i++;
        }

        int idx = i;

        while (i < arr.length - 1 && arr[i] > arr[i + 1]) {
            i++;
        }
        return idx;
    }
}
