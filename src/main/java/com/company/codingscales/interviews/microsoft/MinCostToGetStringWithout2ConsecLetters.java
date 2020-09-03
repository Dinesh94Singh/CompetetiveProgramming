package com.company.codingscales.interviews.microsoft;

public class MinCostToGetStringWithout2ConsecLetters {
    public static void main(final String[] args) {
        final String s1 = "ab";
        final int[] nums1 = {1,3};
        final String s2 = "abccbd";
        final int[] nums2 = {0,1,2,3,4,5};
        final String s3 = "aabbcc";
        final int[] nums3 = {1,2,1,2,1,2};
        final String s4 = "aaaa";
        final int[] nums4 = {3,4,5,6};
        final String s5 = "ababa";
        final int[] nums5 = {10,5,10,5,10};
        System.out.println(getMinCost(s1, nums1));
        System.out.println(getMinCost(s2, nums2));
        System.out.println(getMinCost(s3, nums3));
        System.out.println(getMinCost(s4, nums4));
        System.out.println(getMinCost(s5, nums5));
    }

    private static int getMinCost(final String s, final int[] nums) {
        int res = 0;
        int sum = nums[0], max = nums[0];
        for(int i=1;i<s.length();i++) {
            if(s.charAt(i) != s.charAt(i-1)) {
                res += sum - max;
                sum = nums[i];
                max = nums[i];
            }else {
                sum += nums[i];
                max = Math.max(max, nums[i]);
            }
        }
        res += sum - max;
        return res;
    }
}
