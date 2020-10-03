package com.company.codingscales.leetcode.concepts.arrays;

public class FindDuplicate {
    int findDuplicate(int[] nums) {
        int n = nums.length;
        int slow = nums[0], fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast); // cycle detected

        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        } // find the element

        return slow;
    }
}
