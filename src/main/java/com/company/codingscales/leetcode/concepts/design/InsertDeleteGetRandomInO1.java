package com.company.codingscales.leetcode.concepts.design;

import java.util.*;

public class InsertDeleteGetRandomInO1 {
    HashMap<Integer, Integer> keyToIdx;
    List<Integer> list;
    int currSize = 0;
    Random random;

    /**
     * Initialize your data structure here.
     */
    public InsertDeleteGetRandomInO1() {
        keyToIdx = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (keyToIdx.containsKey(val))
            return false;

        keyToIdx.put(val, list.size());
        list.add(currSize++, val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!keyToIdx.containsKey(val))
            return false;

        int idx = keyToIdx.get(val);
        keyToIdx.remove(val);
        if (idx == currSize - 1) {
            currSize--;
            return true;
        }

        int v = list.get(currSize - 1);
        list.set(idx, v);
        keyToIdx.put(v, idx);
        currSize--;
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        if (currSize == 0)
            return -1;

        int randomIdx = random.nextInt(currSize);
        return list.get(randomIdx);
    }
}
