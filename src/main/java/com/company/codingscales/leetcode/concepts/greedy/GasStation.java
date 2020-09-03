package com.company.codingscales.leetcode.concepts.greedy;

import com.company.codingscales.templates.LeetCodeInputHelpers;

public class GasStation {
    public static int canCompleteCircuit(final int[] gallons, final int[] distances) {
        int total = 0;

        for (int i = 0; i < gallons.length; i++) {
            total += gallons[i] - distances[i];
        }

        if (total < 0) return -1;

        int start = 0;
        total = 0;
        for(int i = 1; i <= gallons.length; i++) {
            total += gallons[i-1] - distances[i-1];

            if (total < 0) {
                start = i;
                total = 0;
            }
        }

        return start;
    }

    public static void main(final String[] args) {
        final GasStation s = new GasStation();
        s.canCompleteCircuit(LeetCodeInputHelpers.stringToIntArray("[]"), LeetCodeInputHelpers.stringToIntArray("[]"));
    }
}
