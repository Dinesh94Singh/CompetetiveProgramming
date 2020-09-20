package com.company.codingscales.leetcode.concepts.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * There are N Workers, out of which we need to choose K workers, such that, it takes min cost to hire these K workers
 *
 * Workers are paid in comparison with other workers by comparing ratios of their wage to quality.
 * ratio = wage / quality -> wage => ratio * quality -> we are finding K persons wage => quality -> k ppl in the group.
 * Ratio would be with who ever is maximum.
 */
public class MinimumCostToHireKWorkers {
    static class Worker implements Comparator<Worker> {
        int quality;
        int wage;
        double ratio;

        Worker(final int quality, final int wage) {
            this.quality = quality;
            this.wage = wage;
            this.ratio = (double) wage / quality;
        }

        @Override
        public int compare(final Worker worker1, final Worker worker2) {
            return Double.compare(worker2.ratio, worker1.ratio);
        }
    }

    public static double mincostToHireWorkers(final int[] quality, final int[] wage, final int K) {
        if (K == 0)
            return 0;
        final int n = quality.length;
        final Worker[] workers = new Worker[n];
        for(int i = 0; i < n; i++) {
            workers[i] = new Worker(quality[i], wage[i]);
        }

        Arrays.sort(workers);
        final PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int totalQuantity = 0;
        double ans = 1e9;
        for (int i = 0; i < n; i++) {
            totalQuantity += workers[i].quality;
            maxHeap.offer(workers[i].quality);

            if (maxHeap.size() > K) {
                totalQuantity -= maxHeap.peek();
                maxHeap.poll();
            }

            if (maxHeap.size() == K)
                ans = Math.min(ans, totalQuantity * workers[i].ratio);
        }

        return ans;
    }
}
