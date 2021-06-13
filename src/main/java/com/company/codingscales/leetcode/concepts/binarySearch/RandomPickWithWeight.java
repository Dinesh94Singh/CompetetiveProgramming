package com.company.codingscales.leetcode.concepts.binarySearch;

import java.util.ArrayList;
import java.util.List;

// TODO: This is a very important problem in 2020 = Like LRU (ML concept) - Do all variants of this problem
public class RandomPickWithWeight {
    private int[] prefixSums;
    private int totalSum;

    // The probability of selecting an element is w[i] / SumOf(W)
    // Reasoning behind the need of prefix sum => You need to explode everything => like if weight is [1, 3] => It should actually be => [1(item1), 1(item2), 1(item2), 1(item2)] => If you do random now, it will get the item2 most times. So, if u do the sum * random number b/w (0, 1) and mux with total sum => since the max W[i] dominates more in the overall sum, the number being that, would be high
    RandomPickWithWeight(int[] w) {
        this.prefixSums = new int[w.length];

        List<Integer> a = new ArrayList<>();
        int prefixSum = 0;
        for (int i = 0; i < w.length; ++i) {
            prefixSum += w[i];
            this.prefixSums[i] = prefixSum;
        }
        this.totalSum = prefixSum;
    }

    public int pickIndex() {
        // target will be in the range of 0 till w.length;

        double target = this.totalSum * Math.random(); // There are 2 ways of scaling the random offset target -> With range, or mux the totalSum with random number b/w 0 and 1. Here we are doing 0 and 1 way.

        // run a binary search to find the target zone
        int low = 0, high = this.prefixSums.length;
        while (low < high) {
            // better to avoid the overflow
            int mid = low + (high - low) / 2;
            if (target > this.prefixSums[mid])
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    public int pickIndexLinear() {
        double target = this.totalSum * Math.random();
        int i = 0;
        // run a linear search to find the target zone
        for (; i < this.prefixSums.length; ++i) {
            if (target < this.prefixSums[i])
                return i;
        }
        // to have a return statement, though this should never happen.
        return i - 1;
    }

    public static void main(String[] args) {
        RandomPickWithWeight randomPickWithWeight = new RandomPickWithWeight(new int[]{1, 3}); // if u run the pickIndex => You should get index 1 => 3 times, and index 0 1 time
        System.out.println(randomPickWithWeight.pickIndexLinear());
        System.out.println(randomPickWithWeight.pickIndexLinear());
        System.out.println(randomPickWithWeight.pickIndexLinear());
        System.out.println(randomPickWithWeight.pickIndexLinear());
    }
}
