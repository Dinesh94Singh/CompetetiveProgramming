package com.company.codingscales.leetcode.concepts.binarySearch;

import java.util.Arrays;

public class MinimumTimeToCompleteTrips {

    public long minimumTime(int[] time, int totalTrips) {
        Arrays.sort(time);
        long tripsMade = 0;

        int max_time = 0;
        for (int t : time) {
            max_time = Math.max(max_time, t);
        }

        long lo = 1;
        long hi = (long) max_time * totalTrips;
        long res = 0;

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;

            long inThisTime = 0;
            for (int i = 0; i < time.length; i++) {
                if (time[i] <= mid) {
                    inThisTime += mid / time[i];
                }
            }

            tripsMade = inThisTime;

            if (totalTrips > tripsMade) { // still need to make trips
                lo = mid + 1;
            } else {
                res = mid;
                hi = mid - 1;
            }
        }

        return res;
    }


    public static void main(String[] args) {
        MinimumTimeToCompleteTrips s = new MinimumTimeToCompleteTrips();

        s.minimumTime(new int[]{100}, 10000000);
    }
}
