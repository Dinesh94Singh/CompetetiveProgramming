package com.company.codingscales.leetcode.concepts.design;

import java.util.ArrayList;
import java.util.List;

public class CandyCrush {
    List<int[]> pos;

    /**
     * you need to crush elements which are same at least thrice either horizontally or vertically;
     */
    public int[][] candyCrush(int[][] board) {
        pos = new ArrayList<>();
        int R = board.length;
        int C = R > 0 ? board[0].length : 0;

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if (board[i][j] != 0) {
                    if (i + 2 < R && board[i + 1][j] == board[i][j] && board[i+2][j] == board[i][j]) {
                        pos.add(new int[]{i, j});
                        pos.add(new int[]{i + 1, j});
                        pos.add(new int[]{i + 2, j});
                    }

                    if (j + 2 < C && board[i][j+1] == board[i][j] && board[i][j+2] == board[i][j]) {
                        pos.add(new int[]{i, j});
                        pos.add(new int[]{i, j+1});
                        pos.add(new int[]{i, j+2});
                    }
                }
            }
        }


        if (pos.isEmpty())
            return board; // nothing to crush

        for(int[] each : pos) {
            board[each[0]][each[1]] = 0; // mark it as zero
        }

        // Remove elements
        for(int c = 0; c < C; c++) { // for each column
            int top = R - 1; // start at the last row and find the row, which can be compressed.
            int bottom = R - 1;

            while (top >= 0) { // remove rows
                if (board[top][c] != 0) {
                    board[bottom][c] = board[top][c];
                    bottom--;
                }
                top--;
            }

            // like sliding window, the last window contains all 0's and top went below 0, so its bottom responsibility to replace all of them with 0's
            while (bottom >= 0) {
                board[bottom][c] = 0;
                bottom--;
            }
        }

        return candyCrush(board);
    }
}
