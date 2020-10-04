package com.company.codingscales.leetcode.concepts.bfs;

public class GameOfLife {
    public static void gameOfLife(final int[][] board) {
        final int R = board.length;
        final int C = R > 0 ? board[0].length : 0;

        final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};
        // basic sol is create a copy of the board
        // alive - alive (1), dead - dead (0) => No state change
        // alive - dead (-1), dead - alive (2) => Stage change
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                int totalPop = 0;
                for(int[] each : directions) {
                    int x = each[0] + i;
                    int y = each[1] + j;

                    if (0 <= x && x < R && 0 <= y && y < C && Math.abs(board[x][y]) == 1)
                        totalPop += 1;
                }

                if (board[i][j] == 1 && (totalPop < 2 || totalPop > 3))
                    board[i][j] = -1;
                else if (board[i][j] == 0 && (totalPop == 3))
                    board[i][j] = 2;
            }
        }

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if (board[i][j] > 0)
                    board[i][j] = 1;
                else
                    board[i][j] = 0;
            }
        }
    }
}
