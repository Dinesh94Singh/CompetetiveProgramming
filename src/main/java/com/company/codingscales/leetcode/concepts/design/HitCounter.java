package com.company.codingscales.leetcode.concepts.design;

public class HitCounter {
    int[][] counter;

    public HitCounter() {
        counter = new int[300][2];
    }

    public void hit(int timestamp) {
        int idx = timestamp % 300;

        if (counter[idx][0] == timestamp) {
            counter[idx][1]++;
        } else {
            counter[idx][0] = timestamp;
            counter[idx][1] = 1;
        }
    }

    public int getHits(int timestamp) {
        int hits = 0;
        for(int i = 0; i < 300; i++) {
            if (timestamp - counter[i][0] < 300)
                hits += counter[i][1];
        }

        return hits;
    }
}
