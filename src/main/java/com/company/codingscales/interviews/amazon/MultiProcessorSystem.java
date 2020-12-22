package com.company.codingscales.interviews.amazon;

import java.util.*;

public class MultiProcessorSystem {
    public static int minTimeHeapSolution(int n, List<Integer> activity, long processes) { // didn't pass all test cases
        Queue<Integer> maxPq = new PriorityQueue<>(n, Comparator.reverseOrder());
        maxPq.addAll(activity);
        int time = 0;
        while (processes > 0L) {
            int ability = maxPq.poll();
            processes -= ability;
            ability /= 2;
            if (ability > 0) {
                maxPq.add(ability);
            }
            time++;
        }
        return time;
    }
}
