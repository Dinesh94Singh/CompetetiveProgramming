package com.company.codingscales.leetcode.concepts.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NumberOfIslands {
    private void bfs(final int r, final int c, final int R, final int C, final char[][] grid) {
        final int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        final ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(r*C + c);
        while(!deque.isEmpty()) {
            final int offset = deque.removeLast();
            final int x = offset / C;
            final int y = offset % C;

            grid[x][y] = 0;

            for(final int[] direction: directions) {
                final int m = x + direction[0];
                final int n = y + direction[1];

                if (0 <= m && m < R && 0 <= n && n < C && grid[m][n] == '1')
                    deque.add(m*C+n);
            }
        }
    }
    public int numIslands(final char[][] grid) {
        final int R = grid.length;
        final int C = R > 0 ? grid[0].length : 0;
        int count = 0;

        for(int i = 0; i<R; i++) {
            for(int j = 0; j<C; j++) {
                if (grid[i][j] == '1') {
                    count += 1;
                    bfs(i, j, R, C, grid);
                }
            }
        }
        return count;
    }
}
