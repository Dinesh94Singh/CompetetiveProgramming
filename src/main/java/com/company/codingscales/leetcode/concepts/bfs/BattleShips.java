package com.company.codingscales.leetcode.concepts.bfs;

public class BattleShips {
    public int battleships(final char[][] board) {
        final int m = board.length;
        if (m==0) return 0;
        final int n = board[0].length;

        int count=0;

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == '.') continue;
                if (i > 0 && board[i-1][j] == 'X') continue;
                if (j > 0 && board[i][j-1] == 'X') continue;
                count++;
            }
        }

        return count;
    }
}
