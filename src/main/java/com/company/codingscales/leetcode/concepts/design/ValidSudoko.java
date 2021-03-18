package com.company.codingscales.leetcode.concepts.design;

import java.util.HashSet;

public class ValidSudoko {
    public static final char NON_DIGIT = '.';

    public boolean isValidSudoku(char[][] board) {
        int R = board.length;
        int C = R > 0 ? board[0].length : 0;

        HashSet<Integer>[] rows = new HashSet[9];
        HashSet<Integer>[] cols = new HashSet[9];
        HashSet<Integer>[] box = new HashSet[9];

        for(int i = 0; i < 9; i++) {
            rows[i] = new HashSet<Integer>();
            cols[i] = new HashSet<Integer>();
            box[i] = new HashSet<Integer>();
        }

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if (board[i][j] != NON_DIGIT) {
                    int n = Character.getNumericValue(board[i][j]);

                    int startIdx = (i / 3) * 3 + j / 3;
                    HashSet<Integer> row = rows[i];
                    HashSet<Integer> col = cols[j];
                    HashSet<Integer> b = box[startIdx];

                    if (row.contains(n) || col.contains(n) || b.contains(n))
                        return false;
                    row.add(n);
                    col.add(n);
                    b.add(n);
                }
            }
        }

        return true;
    }
}
