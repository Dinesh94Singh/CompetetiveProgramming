package com.company.codingscales.leetcode.concepts.bfs;

import com.company.codingscales.templates.Print2DArray;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;

public class SurroundedRegions {
    public void solve(final char[][] board) {
        final int R = board.length;
        final int C = R > 0 ? board[0].length : 0;

        final HashSet<Integer> hs = new HashSet<>();

        final ArrayDeque<Integer> dq = new  ArrayDeque<>(); // positions

        for(int i = 0; i < R; i++) {
            if (board[i][0] == 'O')
                dq.add(i*C + 0);

            if (board[i][C - 1] == 'O')
                dq.add(i*C + (C - 1));
        }

        for(int i = 0; i < C; i++) {
            if (board[0][i] == 'O')
                dq.add(i);
            if (board[R - 1][i] == 'O')
                dq.add((R - 1)*C + i);
        }

        final int[][] directions = new int[][] {{1,0}, {-1,0}, {0,-1}, {0,1}};
        while (!dq.isEmpty()) {
            final int pos = dq.removeFirst();
            final int r = pos / C;
            final int c = pos % C;

            hs.add(pos);

            for(final int[] each: directions) {
                final int m = each[0] + r;
                final int n = each[1] + c;

                if (0 <= m && m < R && 0 <= n && n < C && board[m][n] == 'O')
                    dq.addLast(m*C + n);
            }
        }

        for(final char[] eachBoard: board)
            Arrays.fill(eachBoard, 'X');

        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                final int pos = i * C + j;

                if (hs.contains(pos))
                    board[i][j] = 'O';
            }
        }
    }

    public static void main(final String[] args) {
        final char[][] board = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        final SurroundedRegions s = new SurroundedRegions();
        s.solve(board);
        Print2DArray.printCharArray(board);
        System.out.println("Done !!");
    }
}
