package com.company.codingscales.leetcode.concepts.arrays;

public class WordSearch {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int R;
    int C;

    boolean dfs(char[][] board, String word, int x, int y) {
        if (word.equals(""))
            return true;
        char temp = board[x][y];
        board[x][y] = '#';
        boolean res = false;
        for(int[] each : directions) {
            int X = x + each[0];
            int Y = y + each[1];

            if (0 <= X && X < R && 0 <= Y && Y < C && board[X][Y] == word.charAt(0)) {
                res |= dfs(board, word.substring(1), X, Y);
                if (res)
                    return true;
            }
        }
        board[x][y] = temp;
        return res;
    }

    public boolean exist(char[][] board, String word) {
        R = board.length;
        C = R > 0 ? board[0].length : 0;
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word.substring(1), i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
    }
}
