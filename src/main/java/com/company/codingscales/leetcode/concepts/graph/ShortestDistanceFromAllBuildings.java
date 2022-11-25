package com.company.codingscales.leetcode.concepts.graph;

import java.util.ArrayDeque;

public class ShortestDistanceFromAllBuildings {
    int[][] distance;
    int[][] reach;
    int R, C;

    public int shortestDistance(int[][] grid) {
        R = grid.length;
        C = R > 0 ? grid[0].length : 0;

        distance = new int[R][C];
        reach = new int[R][C];

        int totalBuildings = 0;

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                int x = grid[i][j];

                if (x == 1) {
                    totalBuildings++;
                    performBFS(i, j, grid);
                }
            }
        }

        int minDist = Integer.MAX_VALUE;

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if (grid[i][j] == 0 && reach[i][j] == totalBuildings) {
                    minDist = Math.min(minDist, distance[i][j]);
                }
            }
        }

        if (minDist == Integer.MAX_VALUE)
            return -1;

        return minDist;
    }

    private int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private void performBFS(int i, int j, int[][] grid) {

        ArrayDeque<int[]> dq = new ArrayDeque<>();
        boolean[][] visited = new boolean[R][C];

        dq.offerLast(new int[]{i, j});
        int dist = 0;

        while(!dq.isEmpty()) {
            int n = dq.size();
            dist++;

            for(int k = 0; k < n; k++) {
                int[] curr = dq.pollFirst();

                for(int[] d : directions) {
                    int x = curr[0] + d[0];
                    int y = curr[1] + d[1];

                    if (0 <= x && x < R && 0 <= y && y < C && !visited[x][y] && grid[x][y] == 0) {
                        reach[x][y]++;
                        visited[x][y] = true;
                        distance[x][y] += dist;

                        dq.offerLast(new int[]{x, y});
                    }
                }
            } // end of level-loops
        }
    }
}
