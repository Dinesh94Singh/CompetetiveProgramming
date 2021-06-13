package com.company.codingscales.leetcode.concepts.binarySearch;

import java.util.*;

public class LeftMostColumnWith1 {
    static interface BinaryMatrix {
        List<Integer> dimensions();
        int get(int r, int c);
    }

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> l = binaryMatrix.dimensions();
        int R = l.get(0);
        int C = l.get(1);

        int smallestIdx = Integer.MAX_VALUE;
        for(int row = 0; row < R; row++) { // for each row, we get the lowest column and maintain a global result
            int lo = 0, hi = C - 1;
            while (lo < hi) {
                int mid = (lo + (hi - lo) / 2);

                if (binaryMatrix.get(row, mid) == 0) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }

            if (binaryMatrix.get(row, lo) == 1) {
                smallestIdx = Math.min(smallestIdx, lo);
            }

        }

        return smallestIdx == Integer.MAX_VALUE ? -1 : smallestIdx;
    }

    // for this what guarantees that columns are sorted as well ?
    public int leftMostColumnWithOneWithoutRowBinarySearch(BinaryMatrix binaryMatrix) {
        List<Integer> l = binaryMatrix.dimensions();
        int R = l.get(0);
        int C = l.get(1);

        int row = 0, col = C - 1;

        while (row < R && col >= 0) {
            if (binaryMatrix.get(row, col) == 0) {
                row++;
            } else {
                col--;
            }
        }

        return col == C - 1 ? -1 : col + 1;
    }

}
