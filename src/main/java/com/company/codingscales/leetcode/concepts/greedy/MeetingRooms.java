package com.company.codingscales.leetcode.concepts.greedy;

import java.util.Arrays;

public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }

            return a[1] - b[1];
        });


        for(int i = 0; i < intervals.length - 1; i++) {
            if (isOverlap(intervals, i, i + 1)) {
                return false;
            }
        }

        return true;
    }

    private boolean isOverlap(int[][] A, int i, int j) {
        int startA = A[i][0], endA = A[i][1];
        int startB = A[j][0], endB = A[j][1];

        /*      A       B
            |------||------|
                B       A
        */
        boolean c1 = startA <= startB && endA <= startB;
        boolean c2 = startB <= startA && endB <= startA;

        if (!(c1 || c2))
            return true;
        return false;
    }
}
