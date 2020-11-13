package com.company.codingscales.leetcode.concepts.arrays;

public class SearchA2dMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int R = matrix.length;
        int C = R > 0 ? matrix[0].length : 0;

        int r = R - 1;
        int c = 0;

        while (0 <= r && r < R && 0 <= c && c < C) {
            int val = matrix[r][c];

            if (target > val) {
                c++;
            } else if (target < val) {
                r--;
            } else {
                return true;
            }
        }

        return false;
    }
}
