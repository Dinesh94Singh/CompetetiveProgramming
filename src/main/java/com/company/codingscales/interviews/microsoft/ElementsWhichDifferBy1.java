package com.company.codingscales.interviews.microsoft;

import java.util.HashSet;
import java.util.Set;

public class ElementsWhichDifferBy1 {
    public static void main(final String[] args) {
        final int[] nums1 = {7};
        final int[] nums2 = {4,3};
        final int[] nums3 = {11, 1, 8, 12, 14};
        final int[] nums4 = {5 ,5 ,5, 5, 5};
        final int[] nums5 = {4, 10, 8, 5, 9};
        System.out.println(solve(nums1));
        System.out.println(solve(nums2));
        System.out.println(solve(nums3));
        System.out.println(solve(nums4));
        System.out.println(solve(nums5));
    }

    private static boolean solve(final int[] nums) {
        final Set<Integer> set = new HashSet<>();
        for(final int n : nums) {
            if(set.contains(n-1) || set.contains(n+1))
                return true;
            set.add(n);
        }
        return false;
    }
}
