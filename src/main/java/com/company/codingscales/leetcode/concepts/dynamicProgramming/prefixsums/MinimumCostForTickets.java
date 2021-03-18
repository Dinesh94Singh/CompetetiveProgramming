package com.company.codingscales.leetcode.concepts.dynamicProgramming.prefixsums;

public class MinimumCostForTickets {
    private int recHelper(int[] days, int[] costs, int day, int[] dp) { // 3 states -> startidx, endIdx, idx
        if(day >= days.length)
            return 0;

        if(dp[day] != 0) return dp[day];

        int i;

        //Attempt to buy a one-day ticket
        int buyOneDay =  recHelper(days, costs, day + 1, dp) + costs[0];

        //Attempt to buy a seven-day ticket and skip all days that will be included in this ticket
        for(i = day; i < days.length; i++)
            if(days[i] >= days[day] + 7) break;
        int buySevenDays = recHelper(days, costs, i, dp) + costs[1];

        //Attempt to buy a thirty-day ticket and skip all days that will be included in this ticket
        for(i = day; i < days.length; i++)
            if(days[i] >= days[day] + 30) break;
        int buyThirtyDays = recHelper(days, costs, i, dp) + costs[2];

        //return minimum of three options
        int result = Math.min(Math.min(buyOneDay, buySevenDays), buyThirtyDays);
        dp[day] = result;
        return result;
    }

    public int minCostTicketsBottomUp(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        return recHelper(days, costs, 0, dp);
    }

    public int minCostTicketsTopDown(int[] days, int[] costs) {
        int[] dp = new int[30];
        int lastDay = days[days.length - 1];
        int idx = 0;

        for(int i = days[0]; i <= lastDay; i++) {
            if (days[idx] != i) {
                dp[i % 30] = dp[(i - 1) % 30]; // no possibility to make move here, just get previous val
            } else {
                int c1 = dp[Math.max(i-30, 0) % 30] + costs[2];
                int c2 = dp[Math.max(i-7, 0) % 30] + costs[1];
                int c3 = dp[Math.max(i-1, 0) % 30] + costs[0];

                dp[i % 30] = Math.min(c1, Math.min(c2, c3));
                idx++;
            }
        }

        return dp[lastDay % 30];
    }

    public int mincostTickets(int[] days, int[] costs) {
        return minCostTicketsTopDown(days, costs);
        // return minCostTicketsBottomUp(days, costs);
    }
}
