package com.company.codingscales.leetcode.concepts.backtracking;

import java.util.stream.Stream;

public class PathWithMaximumGold {
    public int getMaximumGold(int[][] grid) {
        int max = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                max = Math.max(max, backtrack(i, j, grid, 0));
            }
        }
        return max;
    }

    private int backtrack(int i, int j, int[][] grid, int sum) {
        if (i < 0 || i > grid.length || j < 0 || j > grid[0].length)
            return sum;
        if (grid[i][j] == 0)
            return 0;

        int gold = grid[i][j];

        grid[i][j] = 0; // visited
        int up = backtrack(i + 1, j, grid, sum + gold);
        int down = backtrack(i - 1, j, grid, sum + gold);
        int left = backtrack(i, j - 1, grid, sum + gold);
        int right = backtrack(i, j + 1, grid, sum + gold);

        grid[i][j] = gold;

        return Stream.of(up, down, left, right).max(Integer::compare).get();
    }
}
