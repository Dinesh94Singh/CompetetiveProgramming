package com.company.codingscales.contests;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Q1 {

    static char[][] board;
    static List<List<String>> res;

    static HashSet<Integer> cols;
    static HashSet<Integer> rows;
    static int N;

    public static List<List<String>> solveNQueens(int n) {
        board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';

        res = new ArrayList<>();

        cols = new HashSet<>();
        rows = new HashSet<>();
        N = n;

        dfs(0, 0, n, board);
        return res;
    }

    private static void dfs(int i, int j, int n, char[][] board) {
        for (int i1 = 0; i1 < N; i1++) {
            for (int j1 = 0; j1 < N; j1++)
                System.out.print(board[i1][j1] + " ");
            System.out.println();
        }
        System.out.println(rows);
        System.out.println(cols);
        System.out.println();
        System.out.println("---------------");

        if (n == 0) {
            if (is_board_valid()) {
                List<String> temp = new ArrayList<>();
                for (int x = 0; x < N; x++) {
                    StringBuilder sb = new StringBuilder();
                    for (int y = 0; y < N; y++) {
                        sb.append(board[x][y]);
                    }

                    temp.add(sb.toString());
                }

                res.add(temp);
            }
            return;
        }

        if (i >= N || j >= N || i < 0 || j < 0) {
            return; // out of bounds
        }

        for (int k = 0; k < N; k++) {
            if (!cols.contains(k) && !rows.contains(i)) {
                rows.add(i);
                cols.add(k);
                board[i][k] = 'Q';

                dfs(i, k, n - 1, board);

                board[i][k] = '.';
                rows.remove(i);
                cols.remove(k);
            } else {
                System.out.println("Skipping (" + i + " , " + k + ")");
            }

            if (!rows.contains(k) && !cols.contains(j)) {
                rows.add(k);
                cols.add(j);
                board[k][j] = 'Q';

                dfs(k, j, n - 1, board);

                board[k][j] = '.';
                rows.remove(k);
                cols.remove(j);
            } else {
                System.out.println("Skipping (" + k + " , " + j + ")");
            }
        }
    }

    private static boolean is_board_valid() {
        return cols.size() == rows.size() && cols.size() == N;
    }

    public static void main(String[] argh) {
        List<List<String>> res = solveNQueens(4);
        System.out.println(res);
    }
}
