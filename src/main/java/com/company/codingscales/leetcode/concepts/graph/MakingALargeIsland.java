package com.company.codingscales.leetcode.concepts.graph;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;



public class MakingALargeIsland {
    int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public int largestIsland(int[][] grid) {
        int R = grid.length;
        int C = R > 0 ? grid[0].length : 0;

        HashMap<Integer, Integer> colorToSize = new HashMap<>();
        colorToSize.put(0, 0); // for elements with color - 0, it means, no area -> size == 0
        int color = 2;
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if (grid[i][j] == 1) {
                    // expand the island
                    int area = bfs(i, j, color, grid);

                    // System.out.println("Area is " + area);
                    colorToSize.put(color, area);
                    color++;
                }
            }
        }

        int res = colorToSize.getOrDefault(2, 0);
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if (grid[i][j] == 0) {
                    HashSet<Integer> neighbors = new HashSet<>();

                    for(int[] dir : directions) {
                        int x = dir[0] + i;
                        int y = dir[1] + j;

                        if (x < 0 || x >= R || y < 0 || y >= C) {
                            continue;
                        }

                        neighbors.add(grid[x][y]); // adds the color
                    }

                    // System.out.println(neighbors);

                    int size = 1;
                    for(int p : neighbors) { // only unique colors
                        size += colorToSize.getOrDefault(p, 0);
                    }

                    res = Math.max(res, size);
                }
            }
        }

        return res;
    }

    int bfs(int i, int j, int color, int[][] grid) {
        int R = grid.length;
        int C = R > 0 ? grid[0].length : 0;

        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offerLast(new int[]{i, j});
        grid[i][j] = color;

        int size = 1;
        while (!dq.isEmpty()) {
            int[] curr = dq.pollFirst();

            for(int[] e : directions) {
                int x = curr[0] + e[0];
                int y = curr[1] + e[1];

                if (x < 0 || x >= R || y < 0 || y >= C || grid[x][y] != 1) {
                    continue;
                }

                size++;
                grid[x][y] = color;
                dq.offerLast(new int[]{x, y});
            }
        }

        return size;
    }
    public static void main(String[] args) {
        MakingALargeIsland sol = new MakingALargeIsland();
        sol.largestIsland(new int[][]{{1, 0}, {0, 1}});
    }
}
