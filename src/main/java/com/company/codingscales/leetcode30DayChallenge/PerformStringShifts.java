package com.company.codingscales.leetcode30DayChallenge;

public class PerformStringShifts {
    public String stringShift(final String s, final int[][] shift) {
        int totalShifts = 0;
        final int length = s.length();
        for(final int[] eachShift: shift) {
           totalShifts += eachShift[0] == 0 ? -eachShift[1] : eachShift[1];
        }

        totalShifts = totalShifts % length;
        System.out.println(totalShifts);
        if (totalShifts < 0) {
            // starting substring is removed and added at last
            totalShifts = Math.abs(totalShifts);
            return s.substring(totalShifts).concat(s.substring(0, totalShifts));
        } else {
            // ending substring is removed and added at first
            return s.substring(length - totalShifts).concat(s.substring(0, length - totalShifts));
        }
    }

    public static void main(final String[] args) {
        String input = "abc";
        int[][] shift = new int[][]{{0,1},{1,2}};
        final PerformStringShifts performStringShifts = new PerformStringShifts();
        System.out.println(performStringShifts.stringShift(input, shift));
        input = "abcdefg";
        shift = new int[][]{{1,1},{1,1},{0,2},{1,3}};
        System.out.println(performStringShifts.stringShift(input, shift));
        input = "wpdhhcj";
        shift = new int[][]{{0,7},{1,7},{1,0},{1,3},{0,3},{0,6},{1,2}};
        System.out.println(performStringShifts.stringShift(input, shift));
    }
}
