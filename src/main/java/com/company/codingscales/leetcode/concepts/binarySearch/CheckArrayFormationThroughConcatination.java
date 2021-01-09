package com.company.codingscales.leetcode.concepts.binarySearch;

import java.util.Arrays;
import java.util.Comparator;

public class CheckArrayFormationThroughConcatination {
    private int binarySearch(int val, int[][] pieces) {
        int lo = 0;
        int hi = pieces.length - 1;

        while (lo <= hi) {
            int mid = (lo + (hi - lo) / 2);

            if (pieces[mid][0] == val) {
                return mid;
            } else if (pieces[mid][0] < val) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return -1;
    }

    public boolean canFormArray(int[] arr, int[][] pieces) {
        Arrays.sort(pieces, Comparator.comparingInt((int[] e) -> e[0]));

        int index = 0;
        int n = arr.length;

        while (index < n) {
            int found = binarySearch(arr[index], pieces);
            if (found == -1)
                return false;

            int[] list = pieces[found];
            for(int x : list) {
                if (x != arr[index]) {
                    return false;
                }
                index++;
            }
        }

        return true;
    }
}
