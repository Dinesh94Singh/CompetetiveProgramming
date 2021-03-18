package com.company.codingscales.leetcode.concepts.math;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MinimizeRoundingErrorToMeetTarget {
    public static String minimizeError(String[] prices, int target) {
        int lowerSumLimit = 0, upperSumLimit = 0;
        int len = prices.length;
        PriorityQueue<Double> diffHeap = new PriorityQueue<Double>(len, Collections.reverseOrder());

        for (String price : prices) {
            double p = Double.parseDouble(price);

            lowerSumLimit += Math.floor(p);
            upperSumLimit += Math.ceil(p);

            diffHeap.offer(Math.ceil(p) - p);
        }

        if (target > upperSumLimit || target < lowerSumLimit)
            return "-1";

        double roundingError = 0.0;

        while (!diffHeap.isEmpty()) {
            if (upperSumLimit > target) { // we try to floor first and reach till a point, where things need to be floored.
                // When you ceil or floor, it won't cross beyond 1. Always in range of 0 - 1
                roundingError += (1.0 - diffHeap.poll()); // all that needs to be floored.
                upperSumLimit--;
            } else {
                roundingError += diffHeap.poll(); // all that needs to be ceiled
            }
        }

        return String.format("%.3f", roundingError);
    }

    public String minimizeErrorUsingSorting(String[] prices, int target) {
        int lowerSumLimit = 0, upperSumLimit = 0;
        int len = prices.length;
        CeilPriceWithDiff[] ceilPrices = new CeilPriceWithDiff[len];
        for (int i = 0; i < len; i++) {
            double p = Double.parseDouble(prices[i]);
            lowerSumLimit += Math.floor(p);
            upperSumLimit += Math.ceil(p);
            ceilPrices[i] = new CeilPriceWithDiff((int) Math.ceil(p), Math.ceil(p) - p);
        }
        if (target > upperSumLimit || target < lowerSumLimit) return "-1";

        Arrays.sort(ceilPrices, (p1, p2) -> Double.compare(p2.diff, p1.diff)); // reverse sorted order
        double roundingError = 0.0;
        for (int i = 0; i < ceilPrices.length; i++) {
            if (upperSumLimit > target) {
                roundingError += (1.0 - ceilPrices[i].diff);
                upperSumLimit--;
            } else {
                roundingError += ceilPrices[i].diff;
            }
        }
        return String.format("%.3f", roundingError);
    }

    class CeilPriceWithDiff {
        int ceilPrice;
        double diff;

        public CeilPriceWithDiff(int ceilPrice, double diff) {
            this.ceilPrice = ceilPrice;
            this.diff = diff;
        }
    }

    public static void main(String[] args) {
        System.out.println(minimizeError(new String[]{"0.700", "2.800","4.900"}, 8)); // floor,ceil,ceil
    }
}
