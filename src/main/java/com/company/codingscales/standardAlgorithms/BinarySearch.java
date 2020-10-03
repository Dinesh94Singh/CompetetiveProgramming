package com.company.codingscales.standardAlgorithms;

class BinarySearch {
    static int binarySearch(final int[] nums, final int target, final boolean isLeft) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            final int mid = (left + (right - left) / 2);
            if (nums[mid] > target || (isLeft && nums[mid] == target)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    static int findRotIndex(final int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            final int mid = (left + (right - left) / 2);
            if (nums[mid] > nums[mid + 1])
                return mid + 1;

            if (nums[mid] > nums[nums.length - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left + 1;
    }

    public static int[] searchRange(final int[] nums, final int target) {
        final int lowerBound = binarySearch(nums, target, true);
        if (lowerBound == nums.length || nums[lowerBound] != target) {
            return new int[] {-1, -1};
        }

        final int upperBound = binarySearch(nums, target, false) - 1;
        return new int[]{lowerBound, upperBound};
    }

    public static int lowerBound(final int[] nums, final int target) {
        return binarySearch(nums, target, true);
    }

    public static int upperBound(final int[] nums, final int target) {
        return binarySearch(nums, target, false);
    }
}
