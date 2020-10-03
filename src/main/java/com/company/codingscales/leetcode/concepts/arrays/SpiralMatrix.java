package com.company.codingscales.leetcode.concepts.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0)
            return new ArrayList<>();

        int r = 0, c = 0, R = matrix.length - 1, C = matrix[0].length - 1;

        List<Integer> al = new ArrayList<>();
        while (r <= R && c <= C) {
            for(int i = c; i <= C; i++) {
                al.add(matrix[r][i]);
            }

            r++;

            for(int j = r; j <= R; j++) {
                al.add(matrix[j][C]);
            }

            C--;


            if (r <= R) {
                for(int i = C; i >= c; i--) {
                    al.add(matrix[R][i]);
                }

                R--;
            }

            if (c <= C) {
                for(int j = R; j >= r; j--) {
                    al.add(matrix[j][c]);
                }

                c++;
            }
        }

        return al;
    }
}

