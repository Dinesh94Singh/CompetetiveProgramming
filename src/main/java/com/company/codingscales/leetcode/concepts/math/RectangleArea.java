package com.company.codingscales.leetcode.concepts.math;

public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);

        int overlap = 0;

        int x1 = Math.max(A, E);
        int y1 = Math.max(B, F);

        int x2 = Math.min(C, G);
        int y2 = Math.min(D, H);

        if (x2 > x1 && y2 > y1) {
            // overlap;
            overlap = (x2 - x1) * (y2 - y1);
        }

        return area1 + area2 - overlap; // remove the duplicate occurrences of the overlapping area
    }
}
