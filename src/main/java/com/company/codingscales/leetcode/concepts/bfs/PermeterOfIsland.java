package com.company.codingscales.leetcode.concepts.bfs;

public class PermeterOfIsland {
    public int islandPerimeter(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int neighbor = 0;
        int island = 0;

        for(int i = 0 ; i < row; i ++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 1) {
                    island++;//if you come here, mean we have a island(has 4 sides)
                    //check 2 sides and count how many surrounding blocks we have
                    //based on that
                    if(i+1 < row && grid[i+1][j] == 1) {
                        neighbor++;
                    }
                    if(j+1 < col && grid[i][j+1] == 1) {
                        neighbor++;
                    }
                }
            }
        }
        return island*4 - neighbor*2;
    }
}
