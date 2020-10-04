package com.company.codingscales.leetcode.concepts.bfs;

import java.util.ArrayDeque;

public class Minesweeper {
    public char[][] updateBoard(final char[][] board, final int[] click) {
        final int R = board.length;
        final int C = R > 0 ? board[0].length : 0;

        final int x = click[0];
        final int y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }

        final int[][] directions = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{1,1},{-1,1},{1,-1}};
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offerLast(new int[]{x, y});

        while (!dq.isEmpty()) {
            final int[] pos = dq.pollFirst();
            final int m = pos[0];
            final int n = pos[1];

            int mines = 0;

            for(final int[] each : directions) {
                final int r = m + each[0];
                final int c = n + each[1];

                if (0 <= r && r < R && 0 <= c && c < C && board[r][c] == 'M') {
                    mines++;
                }
            }

            if (mines > 0) {
                board[m][n] = (char) ('0' + mines);
            } else {
                board[m][n] = 'B';

                for(final int[] each : directions) {
                    final int r = m + each[0];
                    final int c = n + each[1];

                    if (0 <= r && r < R && 0 <= c && c < C && board[r][c] == 'E') {
                        dq.offerLast(new int[]{r, c});
                        board[r][c] = 'B';
                    }
                }
            }
        }

        return board;
    }
}
