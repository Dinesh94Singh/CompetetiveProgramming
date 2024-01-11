package com.company.codingscales.leetcode.concepts.dynamicProgramming;

import java.util.*;
import javafx.util.Pair;


public class MaxProfitInJobScheduling {

    public class MaxProfitInJobSchedulingLinearSearch {
        class Interval {
            int start;
            int end;
            int profit;

            public Interval(int s, int e, int p) {
                this.start = s;
                this.end = e;
                this.profit = p;
            }

            public String toString() {
                return "[" + this.start + ", " + this.end + ", " + this.profit + "]";
            }
        }

        class Solution {
            HashMap<Pair<Integer, Integer>, Integer> cache = new HashMap<>();

            public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
                List<Interval> A = new ArrayList<>();

                for (int i = 0; i < startTime.length; i++) {
                    A.add(new Interval(startTime[i], endTime[i], profit[i]));
                }

                Collections.sort(A, (a, b) -> a.start - b.start);

                return dfs(0, A.size(), A, -1);
            }

            private int dfs(int idx, int N, List<Interval> A, Integer prev) {
                if (idx == N) {
                    return 0;
                }

                Pair<Integer, Integer> pair = new Pair<>(idx, prev);

                if (cache.containsKey(pair)) {
                    return cache.get(pair);
                }

                if (prev != -1 && hasOverlap(A.get(prev), A.get(idx))) {
                    int c = dfs(idx + 1, N, A, prev);
                    cache.put(pair, c);
                    return c;
                } else {
                    int c1 = A.get(idx).profit + dfs(idx + 1, N, A, idx);
                    int c2 = dfs(idx + 1, N, A, prev);

                    cache.put(pair, Math.max(c1, c2));
                    return Math.max(c1, c2);
                }
            }

            private boolean hasOverlap(Interval A, Interval B) {
                boolean res = A.end > B.start;
                // System.out.println(A + "\t" + B + " overlap = " + res);
                return res;
            }
        }
    }

    public class MaxProfitInJobSchedulingUsingBinarySearch {
        class Interval {
            int startTime;
            int endTime;
            int profit;

            public Interval(int s, int e, int p) {
                this.startTime = s;
                this.endTime = e;
                this.profit = p;
            }
        }

        HashMap<Integer, Integer> cache;

        public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
            cache = new HashMap<>();
            List<Interval> intervals = new ArrayList<Interval>();
            List<Integer> startTimes = new ArrayList<>();

            for (int i = 0; i < startTime.length; i++) {
                intervals.add(new Interval(startTime[i], endTime[i], profit[i]));
                startTimes.add(startTime[i]);
            }

            intervals.sort((a, b) -> a.startTime - b.startTime);
            startTimes.sort((a, b) -> a - b);


            return find_maximum_profit(0, intervals, startTimes);
        }

        private int find_maximum_profit(int idx, List<Interval> intervals, List<Integer> startTimes) {
            if (idx >= intervals.size())
                return 0;

            if (cache.containsKey(idx))
                return cache.get(idx);

            // at any step, you have 2 steps to make - either schedule the job or skip the job

            // schedule the job
            int endTime = intervals.get(idx).endTime;

            int nextIdx = find_next_idx(endTime, startTimes);

            int profit = intervals.get(idx).profit + find_maximum_profit(nextIdx, intervals, startTimes);

            // skip the job

            profit = Math.max(profit, find_maximum_profit(idx + 1, intervals, startTimes));

            cache.put(idx, profit);
            return profit;
        }

        private int find_next_idx(int endTime, List<Integer> startTimes) {
            // Binary Search
            int i = 0, j = startTimes.size() - 1;
            int nextIndex = startTimes.size();

            while (i <= j) {
                int mid = i + (j - i) / 2;

                if (startTimes.get(mid) < endTime) {
                    // right side
                    i = mid + 1;
                } else {
                    nextIndex = mid;
                    j = mid - 1;
                }
            }

            return nextIndex;
        }
    }
}
