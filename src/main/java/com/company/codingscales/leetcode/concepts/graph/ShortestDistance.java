package com.company.codingscales.leetcode.concepts.graph;

import com.company.codingscales.templates.LeetCodeInputHelpers;

import java.util.ArrayDeque;

public class ShortestDistance {
    static int[][] distances;
    static int[][] directions;
    static int[][] reach;

    private static void performBFS(int i, int j, int R, int C, int[][] grid) {
        final ArrayDeque<int[]> deque = new ArrayDeque<>();
        final boolean[][] visited = new boolean[R][C];
        int level = 1;
        deque.add(new int[]{i, j});

        while (!deque.isEmpty()) {
            final int size = deque.size();
            for (int k = 0; k < size; k++) {
                final int[] pos = deque.removeFirst();
                final int x = pos[0];
                final int y = pos[1];
                for (final int[] dir : directions) {
                    final int m = x + dir[0];
                    final int n = y + dir[1];

                    if (0 <= m && m < R && 0 <= n && n < C && grid[m][n] == 0 && !visited[m][n]) {
                        distances[m][n] += level;
                        visited[m][n] = true;
                        reach[m][n]++;
                        deque.addLast(new int[]{m, n});
                    }
                }
            }
            level++;
        }
    }

    public static int shortestDistance(final int[][] grid) {
        final int R = grid.length;
        final int C = R > 0 ? grid[0].length : 0;
        distances = new int[R][C];
        reach = new int[R][C];
        directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int buildings=0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 1) {
                    buildings++;
                    performBFS(i, j, R, C, grid);
                }
            }
        }

        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == 0 && reach[i][j] == buildings)
                    minDistance = Math.min(minDistance, distances[i][j]);
            }
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    public static void main(final String[] args) {
         System.out.println(shortestDistance(LeetCodeInputHelpers.stringToInt2dArray("[[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]")));
         System.out.println(shortestDistance(LeetCodeInputHelpers.stringToInt2dArray("[[1,2,0]]")));
        System.out.println(shortestDistance(LeetCodeInputHelpers.stringToInt2dArray("[[2,0,0],[0,1,0],[1,0,0]]")));
    }
}
