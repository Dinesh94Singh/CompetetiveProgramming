package com.company.codingscales.leetcode.concepts.arrays;

import java.util.*;

public class KthLargest {
    public static int findKthLargestUsingSorting(final int[] nums, final int k) {
        if (nums.length < k) {
            return -1;
        }
        // Arrays.sort(nums); return nums[nums.length - k]
        final Integer[] n = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(n, Collections.reverseOrder());
        return n[k - 1]; // don't forget the -1
    }

    public static int findKthLargest(final int[] nums, final int k) {
        if (nums.length == 0) {
            return 0;
        }
        final PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(final int each : nums) {
            if (minHeap.size() < k) {
                minHeap.offer(each);
            } else {
                if (minHeap.peek() < each) { // peek has the smallest value -> remove this
                    minHeap.poll();
                    minHeap.offer(each);
                }
            }
        }
        return minHeap.peek();
    }

    private static void swap(final int[] nums, final int i, final int j) {
        final int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    /**
     * Quick Select and Quick Sort -> Quick Sort => O(n2) worst, O(NLogN) best, O(NLogN) avg.
     * In Quick Sort, we select the pivot_index => pivot_index is usually the lo or hi element. We compare everything with this element
     * Doing so, will leave us with the position of index, which is where the pivot_index should lie and finalized. Similarly you repeat this for left and right half.
     *
     * Quick Select => O(n) best case, O(NLogN) avg, O(N2) worst case.
     * In Quick Select, instead of choosing the pivot_index as lo or hi element, we randomly choose, in the hope that, we can get the kth element in the first rec call itself.
     * Now after choosing the pivot_index, we compare the pivot_val with all the other values, and finalize the position of pivot_val in the array.
     * If the position is the target index, we simply return it. If the target index is less than the updated-pivot-index, then it lies in the left-half, else right-half
     */
    static int dc(final int start, final int end, final int k, final int[] nums) {
        if (start > end)
            return -1;

        final Random random = new Random();
        final int pivotIndex = random.nextInt(end - start + 1) + start;

        swap(nums, pivotIndex, end);

        int j = start;
        int i = start;
        while (j < end) {
            if (nums[j] < nums[end]) {
                swap(nums, i, j);
                i++;
            }
            j++;
        }
        swap(nums, end, i);

        if (i == k) {
            return nums[i];
        } else if (i > k) {
            return dc(start, i - 1, k, nums);
        } else {
            return dc(i + 1, end, k, nums);
        }
    }

    int quickSelect(final int[] nums,final int k) {
        return dc(0, nums.length - 1, k, nums);
    }

    public static int findKthLargestUsingQuickSelect(final int[] nums, final int k) {
        // quick select works on divide-and-conquer.
        // quick select is ideally used to find the kth smallest. To find the Kth largest you can find the N - kth smallest.
        final int n = nums.length;
        return dc(0, n - 1, n - k, nums);
    }
}
