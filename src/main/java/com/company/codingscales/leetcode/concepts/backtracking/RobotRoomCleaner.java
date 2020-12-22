package com.company.codingscales.leetcode.concepts.backtracking;

import javafx.util.Pair;
import java.util.HashSet;

/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

/**
 * Similar to {@link com.company.codingscales.leetcode.concepts.strings.RobotBoundedInCircle}
 * Similar to {@link com.company.codingscales.leetcode.concepts.strings.RobotReturnToOrigin}
 */
interface Robot {
    public boolean move();
    public void turnLeft(); // you need this, if we are moving in anti-clock wise direction
    public void turnRight();
    public void clean();
}

public class RobotRoomCleaner {
    Robot robot;
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    HashSet<Pair<Integer, Integer>> visited;

    void moveRobotBack() {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }

    // move in clock wise directions
    void backtrack(int row, int col, int d) {
        Pair<Integer, Integer> p = new Pair<>(row, col);
        visited.add(p);
        robot.clean();

        for(int i = 0; i < 4; i++) {
            int dirIndex = (d + i) % 4; // should continue in the same direction
            int r = row + directions[dirIndex][0];
            int c = col + directions[dirIndex][1];
            if (!visited.contains(new Pair<>(r, c)) && robot.move()) {
                backtrack(r, c, dirIndex);
                moveRobotBack();
            }
            robot.turnRight();
        }
    }

    public void cleanRoom(Robot robot) {
        this.robot = robot;
        visited = new HashSet<>();
        backtrack(0, 0, 0);
    }
}
