package com.company.codingscales.leetcode.concepts.greedy;

public class GasStation {
    public static int canCompleteCircuit(final int[] gas, final int[] cost) {
        int sur = 0;
        int def = 0;

        int i = 0;
        int n = gas.length;
        int startingPos = 0;

        while (i < n) {
            int cost_to_travel = sur + gas[i] - cost[i];
            if (cost_to_travel < 0) {
                startingPos = i + 1;
                sur = 0;
                def += cost_to_travel;
            } else {
                sur = cost_to_travel;
            }
            i++;
        }

        if (sur + def < 0)
            return -1;
        return startingPos;
    }

    public static void main(final String[] args) {
        final GasStation s = new GasStation();
    }
}
