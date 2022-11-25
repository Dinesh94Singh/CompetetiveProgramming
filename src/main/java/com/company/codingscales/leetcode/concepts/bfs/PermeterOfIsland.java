package com.company.codingscales.leetcode.concepts.bfs;

public class PermeterOfIsland {
    public int islandPerimeter(int[][] grid) {
        int R = grid.length;
        int C = R > 0 ? grid[0].length : 0;

        int res = 0;
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if (grid[i][j] == 1) {
                    res += 4;

                    if (i > 0 && grid[i - 1][j] == 1)
                        res -= 2; // share same boundaries, hence remove 2, because, we counted, here and also, in the previous one, but this line should not be counted
                    if (j > 0 && grid[i][j - 1] == 1)
                        res -= 2;
                }
            }
        }

        return res;
    }
}
