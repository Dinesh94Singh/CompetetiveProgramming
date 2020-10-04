package com.company.codingscales.leetcode.concepts.bfs;

import java.util.ArrayDeque;

public class OrangesRotting {
    /**
     * when ever u see, that the result needs to starts from -1, then, use, count and mark visited when ever adding elements.
     */
    public static int orangesRotting(final int[][] grid) {
        final int R = grid.length;
        final int C = R > 0 ? grid[0].length : 0;

        ArrayDeque<int[]> dq = new ArrayDeque<>();
        int count = 0;

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if (grid[i][j] == 2) {
                    dq.offerLast(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int days = 0;

        while(!dq.isEmpty() && count > 0) {
            final int size = dq.size();
            days++;
            for(int i = 0; i < size; i++) {
                int[] curr = dq.pollFirst();
                int r = curr[0];
                int c = curr[1];

                for(int[] each : directions) {
                    int x = each[0] + r;
                    int y = each[1] + c;

                    if (0 <= x && x < R && 0 <= y && y < C && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        dq.offerLast(new int[]{x, y});
                        count--;
                    }
                }
            }
        }

        return count == 0 ? days : -1;
    }
}
