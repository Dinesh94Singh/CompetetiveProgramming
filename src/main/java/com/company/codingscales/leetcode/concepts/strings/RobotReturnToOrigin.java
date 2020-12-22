package com.company.codingscales.leetcode.concepts.strings;

/**
 * Similar to {@link com.company.codingscales.leetcode.concepts.backtracking.RobotRoomCleaner}
 */
public class RobotReturnToOrigin {
    public boolean returnToOrigin(String moves) {
        if (moves.isEmpty())
            return false;
        int x = 0, y = 0;

        for(final char ch : moves.toCharArray()) {
            switch(ch) {
                case 'U': y += 1; break;
                case 'D': y -= 1; break;
                case 'L': x -= 1; break;
                case 'R': x += 1; break;
                default: break;
            }
        }

        if (x == 0 && y == 0)
            return true;
        return false;
    }
}
