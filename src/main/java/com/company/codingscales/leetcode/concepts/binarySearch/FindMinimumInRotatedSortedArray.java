package com.company.codingscales.leetcode.concepts.binarySearch;

public class FindMinimumInRotatedSortedArray {
    static int findRotatingIndex(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + (hi - lo) / 2);
            if (nums[mid] < nums[0]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    public static int findMin(int[] nums) {
        int N = nums.length;

        if (nums[0] <= nums[N - 1]) {
            return nums[0];
        }

        int index = findRotatingIndex(nums);
        return nums[index];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[] {3, 4, 5, 1, 2}));
        System.out.println(findMin(new int[] {1, 2, 3, 4, 5}));
        System.out.println(findMin(new int[] {1, 2}));
        System.out.println(findMin(new int[] {2, 1}));
        System.out.println(findMin(new int[] {1}));
        System.out.println(findMin(new int[] {3, 1, 2}));
    }
}
