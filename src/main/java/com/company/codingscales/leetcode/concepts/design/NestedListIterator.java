package com.company.codingscales.leetcode.concepts.design;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;

public class NestedListIterator implements Iterator<Integer> {
    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    ArrayDeque<NestedInteger> nestedList;

    public NestedListIterator(final List<NestedInteger> nestedList) {
        this.nestedList = new ArrayDeque<>(nestedList);
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return nestedList.pollFirst().getInteger();
        }

        return -1;

    }

    @Override
    public boolean hasNext() {
        while (!nestedList.isEmpty() && !nestedList.peekFirst().isInteger()) {
            final List<NestedInteger> nl = nestedList.pollFirst().getList();
            for (final NestedInteger n : nl) {
                nestedList.offerFirst(n);
            }
        }

        return !nestedList.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
