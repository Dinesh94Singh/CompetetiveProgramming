package com.company.codingscales.interviews.facebook;

import java.util.Arrays;
import java.util.Random;

public class RandomPickIndex {
    int[] prefix;
    int total;
    public RandomPickIndex(int[] w) {
        prefix = new int[w.length];
        for(int i = 1; i < w.length; i++)
            prefix[i] += (prefix[i - 1] + w[i]);

        total = Arrays.stream(w).reduce(0, Integer::sum);
    }

    public int pickIndex() {
        Random r = new Random();

        double target = total * r.nextDouble();

        for(int i = 0; i < prefix.length; i++) {
            if (prefix[i] > target)
                return i;
        }

        return -1;
    }
}
