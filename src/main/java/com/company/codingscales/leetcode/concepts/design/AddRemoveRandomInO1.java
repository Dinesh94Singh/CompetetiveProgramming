package com.company.codingscales.leetcode.concepts.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class AddRemoveRandomInO1 {
    class RandomizedSet {

        HashMap<Integer, Integer> map;
        List<Integer> al;

        /** Initialize your data structure here. */
        public RandomizedSet() {
            map = new HashMap<>();
            al = new ArrayList<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            } else {
                map.put(val, al.size());
                al.add(val);
                return true;
            }
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (map.containsKey(val)) {
                int idx = map.get(val);

                if (idx == al.size() - 1) {
                    al.remove(al.size() - 1);
                    map.remove(val);
                    return true;
                }

                al.set(idx, al.get(al.size() - 1));
                al.remove(al.size() - 1);

                map.put(al.get(idx), idx);
                map.remove(val);

                return true;
            } else {
                return false;
            }
        }

        /** Get a random element from the set. */
        public int getRandom() {
            int rand = new Random().nextInt(al.size());
            return al.get(rand);
        }
    }
}
