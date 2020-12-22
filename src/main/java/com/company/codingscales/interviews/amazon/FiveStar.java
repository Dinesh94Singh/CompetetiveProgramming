package com.company.codingscales.interviews.amazon;

public class FiveStar {
    public static int fiveStar(int[][] ratings, int target) {
        int n = ratings.length;
        double threshold = n * target / 100.0;
        double percentage = 0.00;
        for(int i = 0; i < n; i++) {
            double a = ratings[i][0];
            double b = ratings[i][1];
            double rate = a / b;
            percentage += rate;
        }
        int maxIndex = 0, res = 0;
        double diff = 0.00, maxDiff = Double.MIN_VALUE;
        while(percentage < threshold) {
            for(int i = 0; i < n; i++) {
                double a = ratings[i][0];
                double b = ratings[i][1];
                double rate = a / b;
                if(rate == 1) {
                    continue;
                }
                double x = ratings[i][0] + 1;
                double y = ratings[i][1] + 1;
                double updated = x / y;

                diff = updated - rate;
                if(diff > maxDiff) {
                    maxDiff = diff;
                    maxIndex = i;
                }
            }
            percentage += maxDiff;
            maxDiff = Double.MIN_VALUE;
            ratings[maxIndex][0] = ratings[maxIndex][0] + 1;
            ratings[maxIndex][1] = ratings[maxIndex][1] + 1;
            res++;
        }
        return res;
    }
}
