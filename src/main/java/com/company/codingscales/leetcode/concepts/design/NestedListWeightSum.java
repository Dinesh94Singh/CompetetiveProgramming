package com.company.codingscales.leetcode.concepts.design;

import java.util.*;

public class NestedListWeightSum {
    public interface NestedInteger {
        public boolean isInteger();

        public Integer getInteger();

        public void setInteger(int value);

        public void add(NestedInteger ni);

        public List<NestedInteger> getList();
    }

    HashMap<Integer, Integer> depthToTotal;

    public int depthSum(List<NestedInteger> nestedList) {
        depthToTotal = new HashMap<>();
        for (int i = 0; i <= 50; i++)
            depthToTotal.put(i, 0);

        for (NestedInteger each : nestedList) {
            helper(each, 1);
        }

        int total = 0;
        for (Map.Entry<Integer, Integer> entry : depthToTotal.entrySet()) {
            total += entry.getKey() * entry.getValue();
        }

        return total;
    }

    void helper(NestedInteger each, int level) {
        if (each.isInteger()) {
            depthToTotal.put(level, depthToTotal.get(level) + each.getInteger());
        } else {
            for (NestedInteger other : each.getList()) {
                helper(other, level + 1);
            }
        }
    }
}