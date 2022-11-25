package com.company.codingscales.leetcode.concepts.arrays;

public class FindWinnerOfATicTacToeGame {
    public String tictactoe(int[][] moves) {
        int[][] grid = new int[3][3];

        int player = 1;
        for(int[] move : moves) {
            grid[move[0]][move[1]] = player;

            if (won(grid, move)) {
                return player < 0 ? "B" : "A";
            }

            player *= -1;
        }
        if (moves.length < 9)
            return "Pending";
        return "Draw";
    }

    boolean won(int[][] grid, int[] move) {
        int r = move[0];
        int c = move[1];

        int total = 0;

        for(int i = 0; i < 3; i++)
            total += grid[r][i];

        if (total == 3 || total == -3)
            return true;

        total = 0;

        for(int i = 0; i < 3; i++)
            total += grid[i][c];

        if (total == 3 || total == -3)
            return true;

        int d1 = 0, d2 = 0;
        for (int i = 0; i < 3; i++) {
            d1 += grid[i][i];
            d2 += grid[i][3 - i - 1];
        }

        if (d1 == 3 || d2 == 3 || d1 == -3 || d2 == -3)
            return true;

        return false;
    }
}
