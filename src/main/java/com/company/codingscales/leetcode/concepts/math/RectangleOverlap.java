package com.company.codingscales.leetcode.concepts.math;

public class RectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if (canFormALine(rec1) || canFormALine(rec2)) {
            return false;
        }

        // check if they don't overlap on left or right or up or down
        return !(
                rec1[2] <= rec2[0] || rec1[3] <= rec2[1] || rec1[0] >= rec2[2] || rec1[1] >= rec2[3]
        );
    }

    boolean canFormALine(int[] rec1) {
        int left1 = rec1[0];
        int right1 = rec1[1];
        int left2 = rec1[2];
        int right2 = rec1[3];

        if (left1 == left2 || right1 == right2) {
            return false;
        }
        return true;
    }
}
