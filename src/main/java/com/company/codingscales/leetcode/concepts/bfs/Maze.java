package com.company.codingscales.leetcode.concepts.bfs;

import com.company.codingscales.templates.LeetCodeInputHelpers;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

public class Maze {
    class Pair {
        public int first;
        public int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public boolean equals(Object obj) {
            Pair other = (Pair) obj;
            return this.first == other.first && this.second == other.second;
        }

        public int hashCode() {
            int hash = 7;
            hash = 31 * hash + this.first * this.second;
            return hash;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(" (");
            sb.append(first);
            sb.append(", ");
            sb.append(second);
            sb.append(") ");

            return sb.toString();
        }
    }

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int sX = start[0], sY = start[1];
        int dX = destination[0], dY = destination[1];

        if (sX == dX && sY == dY) { return true; }

        int R = maze.length;
        int C = R > 0 ? maze[0].length : 0;

        ArrayDeque<Pair> queue = new ArrayDeque<>();
        Set<Pair> visited = new HashSet<>();

        Pair s = new Pair(sX, sY);

        queue.add(s);
        visited.add(s);

        int[][] directions = new int[][] {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i =0; i<size; i++) {
                Pair curr = queue.removeFirst();
                int currX = curr.first, currY = curr.second;

                if (currX == dX && currY == dY) { return true; }

                for(int[] dir : directions) {
                    int tX = currX + dir[0];
                    int tY = currY + dir[1];

                    if (visited.contains(new Pair(tX, tY))) { continue; }

                    while(0 <= tX && tX < R && 0 <= tY && tY < C) {
                        if (maze[tX][tY] == 1) { break; }
                        tX += dir[0];
                        tY += dir[1];
                    }

                    tX-= dir[0];
                    tY-= dir[1];

                    if (visited.contains(new Pair(tX, tY))) { continue; }

                    if (0 <= tX && tX < R && 0 <= tY && tY < C) {
                        Pair temp = new Pair(tX, tY);
                        visited.add(temp);
                        queue.addLast(temp);
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Maze m = new Maze();
        System.out.println(m.hasPath(LeetCodeInputHelpers.stringToInt2dArray("[[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]]"), LeetCodeInputHelpers.stringToIntArray("[0,4]"), LeetCodeInputHelpers.stringToIntArray("[3,2]")));
    }
}
