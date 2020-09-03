package com.company.codingscales.leetcode.concepts.interactive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class BinaryMatrix {
    public List<Integer> dimensions;
    public int[][] binaryMatrix;

    BinaryMatrix(final int r, final int c) {
        binaryMatrix = new int[r][c];
        dimensions = new ArrayList<>();
        dimensions.add(r);
        dimensions.add(c);
    }

    public List<Integer> dimensions() {
        return dimensions;
    }

    public int get(final int r, final int c) {
        return binaryMatrix[r][c];
    }
}

public class BinaryMatrixLeftMostColumnWith1 {
    /**
     * // This is the BinaryMatrix's API interface.
     * // You should not implement it, or speculate about its implementation
     * interface BinaryMatrix {
     *     public int get(int x, int y) {}
     *     public List<Integer> dimensions {}
     * };
     */

    public int leftMostColumnWithOne(final BinaryMatrix binaryMatrix) {
        final List<Integer> dimensions = binaryMatrix.dimensions();
        final int R = dimensions.get(0);
        final int C = dimensions.get(1);

        int i = 0;
        int j = C - 1;
        while(i >= 0 && i < R && j >= 0 && j < C) {
            final int val = binaryMatrix.get(i, j);

            if (val == 0) {
                i += 1;
            } else {
                j -= 1;
            }
        }

        if (j < 0)
            return 0;
        if (i >= R)
            return j < C - 1 ? j + 1 : -1;
        return -1;
    }

    public static void main(final String[] args) {
        final BinaryMatrix binaryMatrix = new BinaryMatrix(2, 2);
        binaryMatrix.binaryMatrix[0][0] = 0;
        binaryMatrix.binaryMatrix[0][1] = 0;
        binaryMatrix.binaryMatrix[1][0] = 0;
        binaryMatrix.binaryMatrix[1][1] = 0;

        final BinaryMatrixLeftMostColumnWith1 b = new BinaryMatrixLeftMostColumnWith1();
        System.out.println(b.leftMostColumnWithOne(binaryMatrix));
    }
}
