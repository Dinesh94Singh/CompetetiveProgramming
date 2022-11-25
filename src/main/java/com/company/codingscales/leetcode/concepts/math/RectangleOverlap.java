package com.company.codingscales.leetcode.concepts.math;

public class RectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if (canFormLine(rec1) || canFormLine(rec2)) {
            return false;
        }

        int x1 = rec1[0];
        int y1 = rec1[1];
        int x2 = rec1[2];
        int y2 = rec1[3];

        int x3 = rec2[0];
        int y3 = rec2[1];
        int x4 = rec2[2];
        int y4 = rec2[3];

        return (x2 > x3) && (y2 > y3) && (x1 < x4) && (y1 < y4);
    }

    boolean canFormLine(int[] rec) {
        int left1 = rec[0];
        int right1 = rec[1];
        int left2 = rec[2];
        int right2 = rec[3];

        if (left1 == left2 || right1 == right2)
            return true;

        return false;
    }
}
