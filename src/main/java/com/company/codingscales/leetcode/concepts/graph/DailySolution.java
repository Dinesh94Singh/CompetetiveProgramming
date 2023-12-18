package com.company.codingscales.leetcode.concepts.graph;

import java.util.*;
import java.util.stream.Collectors;

public class DailySolution {
    class Solution {
        public int shipWithinDays(int[] A, int days) {
            // need to find the capactiy of the ship
    
            // weights[i] - ith package weight
    
            PriorityQueue<List<Integer>> pq = new PriorityQueue<>((x, y) -> {
                System.out.println("List 1 is " + x);
                System.out.println("List 2 is " + y);
    
                System.out.println("Comparing " + x.stream().reduce(0, Integer::sum) + " with " + y.stream().reduce(0, Integer::sum));
    
    
                return x.stream().reduce(0, Integer::sum) - y.stream().reduce(0, Integer::sum);
            });
    
            for (int i = 0; i < days; i++)
                pq.add(new ArrayList<>());
    
            List<Integer> weights = Arrays.stream(A).boxed().collect(Collectors.toList());
    
            Collections.sort(weights, (x, y) -> y - x);
    
            int i = 0;
    
            while (i < A.length) {
                System.out.println(" " + pq);
                List<Integer> peek = pq.peek();
                peek.add(weights.get(i));
                i++;
            }
    
    
            int maxAllowed = Integer.MIN_VALUE;
            while (!pq.isEmpty()) {
                List<Integer> t = pq.poll();
                maxAllowed = Math.max(maxAllowed, t.stream().reduce(0, Integer::sum));
            }
    
            return maxAllowed;
    
        }
    }
    
}
