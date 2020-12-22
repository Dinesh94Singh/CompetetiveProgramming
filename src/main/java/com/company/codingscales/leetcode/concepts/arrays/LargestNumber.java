package com.company.codingscales.leetcode.concepts.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        List<String> list = Arrays.stream(nums).boxed().map(String::valueOf).collect(Collectors.toList());
        list.sort((e1, e2) -> {
            String s1 = e1 + e2;
            String s2 = e2 + e1;

            return s2.compareTo(s1);
        });

        if (list.get(0).equals("0"))
            return "0";
        StringBuilder sb = new StringBuilder();
        for (String each : list) {
            sb.append(each);
        }

        return sb.toString();
    }
}
