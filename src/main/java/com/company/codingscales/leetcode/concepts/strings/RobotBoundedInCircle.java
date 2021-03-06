package com.company.codingscales.leetcode.concepts.strings;

/**
 * Similar to {@link com.company.codingscales.leetcode.concepts.backtracking.RobotRoomCleaner}
 */
public class RobotBoundedInCircle {
    public static boolean isRobotBounded(String instructions) {
        if (instructions.isEmpty())
            return false;
        int x = 0;
        int y = 0;  // initial points of the robot
        String directions = "North"; // initial direction of robot
        /*
                    North
            West                East
                    South

        */
        for (final char ch : instructions.toCharArray()) {
            if (ch == 'G') {
                switch (directions) {
                    case "North":
                        y += 1;
                        break;
                    case "South":
                        y -= 1;
                        break;
                    case "East":
                        x += 1;
                        break;
                    default:
                        x -= 1;
                        break;
                }
            } else if (ch == 'L') {
                switch (directions) {
                    case "North":
                        directions = "West";
                        break;
                    case "West":
                        directions = "South";
                        break;
                    case "South":
                        directions = "East";
                        break;
                    default:
                        directions = "North";
                }
            } else if (ch == 'R') {
                switch (directions) {
                    case "North":
                        directions = "East";
                        break;
                    case "East":
                        directions = "South";
                        break;
                    case "South":
                        directions = "West";
                        break;
                    default:
                        directions = "North";
                        break;
                }
            }
        }

        if (x == 0 && y == 0)
            return true;
        if (directions.equals("North")) // y ? The same pattern will be going to run again & again. When It reaches the same point, then it means its a cycle
            return false;
        return true;


    }
}