package com.company.codingscales.templates;

public class Print2DArray {
    public static void printIntArray(final int[][] board) {
        for(int i =0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printCharArray(final char[][] board) {
        for(int i =0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
