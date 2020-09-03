package com.company.codingscales.leetcode.concepts.hashmap;

import com.company.codingscales.templates.LeetCodeInputHelpers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ThreeSum {
    private void twoSum(int startIdx, int[] nums, List<List<Integer>> al, int remaining) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        list.add(nums[startIdx - 1]);

        int i = startIdx;
        while(i < nums.length) {
            if (map.containsKey(remaining - nums[i])) {
                list.add(nums[map.get(remaining - nums[i])]);
                list.add(nums[i]);
                al.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
                list.remove(list.size() - 1);

                int j = i + 1;
                while (j < nums.length && nums[j] == nums[j-1])
                    j++;
                i = j;
            } else {
                map.put(nums[i], i);
                i++;
            }

        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            twoSum(i + 1, nums, res, -nums[i]);
            int j = i + 1;
            while (j < nums.length && nums[j] == nums[j-1])
                j++;
            i = j;
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeSum sol = new ThreeSum();
        System.out.println(sol.threeSum(LeetCodeInputHelpers.stringToIntArray("[-1,0,1,2,-1,-4]")));
        System.out.println(sol.threeSum(LeetCodeInputHelpers.stringToIntArray("[0,0,0,0,0]")));
    }
}
