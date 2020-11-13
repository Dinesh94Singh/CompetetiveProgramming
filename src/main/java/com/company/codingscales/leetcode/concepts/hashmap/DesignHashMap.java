package com.company.codingscales.leetcode.concepts.hashmap;

import java.util.ArrayList;
import java.util.List;

public class DesignHashMap {
    static class MyHashMap {
        static class Pair<U, V> {
            public U key;
            public V value;

            public Pair(U first, V second) {
                this.key = first;
                this.value = second;
            }

            public U getKey() {
                return key;
            }

            public V getValue() {
                return value;
            }
        }

        static class Bucket {
            List<Pair<Integer, Integer>> bucket;

            Bucket() {
                this.bucket = new ArrayList<>();
            }

            Integer get(Integer key) {
                for(Pair<Integer, Integer> p : bucket) {
                    if (p.getKey().equals(key)) {
                        return p.getValue();
                    }
                }

                return -1;
            }

            void update(Integer key, Integer value) {
                boolean notFound = true;

                for(Pair<Integer, Integer> p : bucket) {
                    if (p.getKey().equals(key)) {
                        p.value = value;
                        notFound = false;
                        break;
                    }
                }

                if (notFound) {
                    bucket.add(new Pair<Integer, Integer>(key, value));
                }
            }

            void remove(Integer key) {
                for(Pair<Integer, Integer> p : bucket) {
                    if (p.getKey().equals(key)) {
                        bucket.remove(p);
                        break;
                    }
                }
            }
        }

        int N = 1000;
        List<Bucket> myMap;


        /** Initialize your data structure here. */
        public MyHashMap() {
            myMap = new ArrayList<>();
            for(int i = 0; i < N; i++) {
                myMap.add(new Bucket());
            }
        }

        /** value will always be non-negative. */
        public void put(int key, int value) {
            int hash = key % N;
            myMap.get(hash).update(key, value);
        }

        /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
        public int get(int key) {
            int hash = key % N;
            return myMap.get(hash).get(key);
        }

        /** Removes the mapping of the specified value key if this map contains a mapping for the key */
        public void remove(int key) {
            int hash = key % N;
            myMap.get(hash).remove(key);
        }
    }
}
