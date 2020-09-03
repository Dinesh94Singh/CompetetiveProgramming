package com.company.codingscales.leetcode.concepts.miscellaneous;

import com.company.codingscales.templates.LeetCodeInputHelpers;
import com.company.codingscales.templates.PrintArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiagonalTraverse {

    private static void helper(final int[][] matrix, int i, int j, final List<Integer> al) {
        while (i >= 0 && j >= 0 && i < matrix.length && j < matrix[0].length) {
            al.add(matrix[i][j]);
            i++;
            j--;
        }
    }


    public static int[] diagonalTraverse(final int[][] matrix) {
        final int R = matrix.length;
        final int C = matrix[0].length;

        final int[] res = new int[R*C];
        int k = 0;
        final List<Integer> al = new ArrayList<Integer>();
        int direction = -1;

        for(int i = 0; i < C; i++) {
            helper(matrix, 0, i, al);

            if (direction == -1) {
                Collections.reverse(al);
            }

            direction = direction == -1 ? 1 : -1;

            for(final int a: al) {
                res[k++] = a;
            }

            al.clear();
        }

        for(int i = 1; i < R; i++) {
            helper(matrix, i, C - 1, al);

            if (direction == -1) {
                Collections.reverse(al);
            }

            direction = direction == -1 ? 1 : -1;

            for(final int a: al) {
                res[k++] = a;
            }

            al.clear();
        }

        return res;
    }

    public static void main(final String[] args) {
        // [1,2,4,7,5,3,6,8,9]
        PrintArray.printArray(diagonalTraverse(LeetCodeInputHelpers.stringToInt2dArray("[[1,2,3],[4,5,6],[7,8,9]]")));
    }
}
