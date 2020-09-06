package com.company.codingscales.interviews.microsoft;

import java.util.Arrays;
import java.util.List;

public class AlladinCheckers {
    static int[][] dirs = {{-2, 2}, {-2, -2}};

    static boolean isValid(char[][] check, int r, int c) {
        int rows = check.length;
        int cols = check[0].length;

        return r >= 0 && r < rows && c >= 0 && c < cols;
    }

    static int getMaxMoves(char[][] check, int r, int c) {
        int ret = 0;
        for(int[] each : dirs) {
            int r2 = r + each[0];
            int c2 = c + each[1];

            int r1 = r + each[0] / 2;
            int c1 = c + each[1] / 2;

            if (isValid(check, r2, c2) && check[r2][c2] == '.' && check[r1][c1] == 'X') {
                check[r1][c1] = '.';
                ret = Math.max(ret, 1 + getMaxMoves(check, r2, c2));
                check[r1][c1] = 'X';
            }
        }
        return ret;
    }

    static int findJafar(List<String> input) {
        int rows = input.size();
        int cols = input.get(0).length();

        char[][] check = new char[rows][cols];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                check[i][j] = input.get(i).charAt(j);
            }
        }

        int x = -1, y = -1;
        for(int r = 0; r < rows; ++r) {
            for(int c = 0; c < cols; ++c) {
                if (check[r][c] == 'O') { // get the pos of the jafar in the checker grid
                    x = r;
                    y = c;
                    break;
                }
            }
        }

        if (x == -1)
            return -1;

        return getMaxMoves(check, x, y);
    }

    public static void main(String[] args) {
        List<String> data = Arrays.asList(
                "..X...",
                "......",
                "....X.",
                ".X....",
                "..X.X.",
                "...O..");
        List<String> data1 = Arrays.asList(
                "X....",
                ".X...",
                "..O..",
                "...X.",
                "....."
        );

        System.out.println("Input1 " + findJafar(data));
        System.out.println("Input2 " + findJafar(data1));
    }
}
