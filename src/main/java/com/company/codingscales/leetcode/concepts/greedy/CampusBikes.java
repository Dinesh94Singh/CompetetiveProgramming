package com.company.codingscales.leetcode.concepts.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

// Still TLE's but good to talk in interviews
public class CampusBikes {
    static class Distance {
        int worker;
        int bike;
        int distance;

        Distance() {
        }

        Distance(int w, int b, int d) {
            worker = w;
            bike = b;
            distance = d;
        }

        public int compareTo(Distance other) {
            if (this.distance != other.distance) {
                return this.distance - other.distance;
            }

            if (this.worker != other.worker) {
                return this.worker - other.worker;
            }

            return this.bike - other.bike;
        }
    }

    public int[] assignBikes(int[][] workers, int[][] bikes) {
        // priority queue solution
        PriorityQueue<Distance> pq = new PriorityQueue<>();
        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                int[] worker = workers[i];
                int[] bike = bikes[j];
                int distance = Math.abs(bike[0] - worker[0]) + Math.abs(bike[1] - worker[1]);

                pq.offer(new Distance(i, j, distance));
            }
        }

        int[] res = new int[workers.length];
        Arrays.fill(res, -1);
        boolean[] bikesOccupied = new boolean[bikes.length];
        while (!pq.isEmpty()) {
            Distance curr = pq.poll();
            if (res[curr.worker] == -1 && !bikesOccupied[curr.bike]) {
                bikesOccupied[curr.bike] = true;
                res[curr.worker] = curr.bike;
            }
        }
        return res;
    }
}
