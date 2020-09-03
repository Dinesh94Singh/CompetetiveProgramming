package com.company.codingscales.leetcode.concepts.dynamicProgramming;

import com.company.codingscales.templates.LeetCodeInputHelpers;
import com.company.codingscales.templates.Print2DArray;

// [0,1,1,1],
// [1,1,1,1],
// [0,1,1,1]
public class CountSquaresWith1s {
    private static int[][] directions = new int[][] {{-1, 0}, {0, -1}, {-1, -1}};
    private static int helper(int i, int j, int[][] dp, int[][] matrix) {
        int x, y;
        int minCost = Integer.MAX_VALUE;
        boolean canotFormSquare = false;
        for(int[] dir : directions) {
            x = dir[0] + i;
            y = dir[1] + j;

            if (0 <= x && x < matrix.length && 0 <= y && y < matrix[0].length) {
                minCost = Math.min(minCost, dp[x][y]);
            } else {
                canotFormSquare = true;
                break;
            }
        }

        if (canotFormSquare) { dp[i][j] = 1; return 1; }
        System.out.printf("\t %d \n", minCost);
        dp[i][j] = 1 + minCost;
        return dp[i][j];
    }


    public static int countSquares(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;

        int[][] dp = new int[R][C];
        int total = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    System.out.printf("%d , %d\n", i, j);
                    total += helper(i, j, dp, matrix);
                }
            }
        }

        Print2DArray.printIntArray(dp);

        return total;
    }

    public static void main(String[] args) {
        CountSquaresWith1s sol = new CountSquaresWith1s();
        System.out.println(sol.countSquares(LeetCodeInputHelpers.stringToInt2dArray("[[0,1,1,1],[1,1,1,1],[0,1,1,1]]")));
    }
}
