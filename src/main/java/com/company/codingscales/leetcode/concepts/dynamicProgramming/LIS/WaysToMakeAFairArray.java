package com.company.codingscales.leetcode.concepts.dynamicProgramming.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class WaysToMakeAFairArray {
    HashMap<Integer, Integer> hm = new HashMap<>();

    boolean validate(List<Integer> nums) {
        int evenTotal = 0, oddTotal = 0;
        for(int i = 0; i < nums.size(); i+= 2) {
            evenTotal += nums.get(i);
        }

        for(int i = 1; i < nums.size(); i+= 2) {
            oddTotal += nums.get(i);
        }

        return evenTotal == oddTotal;
    }

    private int dfs(List<Integer> nums) {
        int count = 0;

        for(int i = 0; i < nums.size(); i++) {
            List<Integer> temp = new ArrayList<>(nums);
            int key = nums.get(i);
            temp.remove(i);
            if (validate(temp))
                count++;
            dfs(temp);
        }

        return count;
    }

    public int waysToMakeFair(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        return dfs(list);
    }

    public static void main(String[] args) {
        final WaysToMakeAFairArray waysToMakeAFairArray = new WaysToMakeAFairArray();
        System.out.println(waysToMakeAFairArray.waysToMakeFair(new int[]{6, 1, 7, 4, 1}));
    }
}
