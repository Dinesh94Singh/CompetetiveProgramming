package com.company.codingscales.leetcode.concepts.bfs;

import com.company.codingscales.templates.LeetCodeInputHelpers;
import com.company.codingscales.templates.Print2DArray;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
    public class Pair<U, V, W> {
        U u;
        V v;
        W w;

        Pair(final U u, final V v, final W w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        U getFirst() {
            return this.u;
        }

        V getSecond() {
            return this.v;
        }

        W getThird() {
            return this.w;
        }
    }

    public void wallsAndGates(final int[][] rooms) {
        final ArrayDeque<Pair<Integer, Integer, Integer>> sources = new ArrayDeque<>();
        final int R = rooms.length;
        final int C = rooms[0].length;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (rooms[i][j] == 0) {
                    sources.addLast(new Pair<Integer, Integer, Integer>(i, j, 0));
                }
            }
        }

        final int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Integer u, v, w;
        int x, y;
        while (!sources.isEmpty()) {
            final Pair<Integer, Integer, Integer> curr = sources.removeFirst();
            u = curr.getFirst();
            v = curr.getSecond();
            w = curr.getThird();

            for (final int[] each : directions) {
                x = u + each[0];
                y = v + each[1];

                if (x < 0 || x >= R || y < 0 || y >= C || rooms[x][y] == -1) {
                    continue;
                }

                if (rooms[x][y] > w + 1) {
                    rooms[x][y] = w + 1;
                    sources.addLast(new Pair<Integer, Integer, Integer>(x, y, w + 1));
                }
            }
        }
    }

    // Level order guarantees to get the best results.
    public void wallsAndGatesLevelOrderBFS(final int[][] rooms) {
        final int m = rooms.length;
        if(m == 0)  return;
        final int n = rooms[0].length;
        if(n == 0)  return;
        final Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(rooms[i][j] == 0)
                    q.offer(new int[] {i, j});
            }
        }

        final int inf = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            final int size = q.size();
            for(int i = 0; i < size; i++){
                final int[] cur = q.poll();
                final int row = cur[0];
                final int col = cur[1];
                if(row-1 >= 0 && rooms[row-1][col] == inf){
                    rooms[row-1][col] = rooms[row][col]+1;
                    q.offer(new int[] {row-1, col});
                }
                if(row+1 < m && rooms[row+1][col] == inf){
                    rooms[row+1][col] = rooms[row][col]+1;
                    q.offer(new int[] {row+1, col});
                }
                if(col-1 >= 0 && rooms[row][col-1] == inf){
                    rooms[row][col-1] = rooms[row][col]+1;
                    q.offer(new int[] {row, col-1});
                }
                if(col+1 < n && rooms[row][col+1] == inf){
                    rooms[row][col+1] = rooms[row][col]+1;
                    q.offer(new int[] {row, col+1});
                }
            }
        }
    }

    public static void main(final String[] args) {
        final WallsAndGates w = new WallsAndGates();
        final int[][] rooms = LeetCodeInputHelpers.stringToInt2dArray("[[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]");
        w.wallsAndGates(rooms);
        Print2DArray.printIntArray(rooms);
    }
}
