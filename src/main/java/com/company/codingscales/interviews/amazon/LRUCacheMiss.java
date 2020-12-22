package com.company.codingscales.interviews.amazon;

import java.util.*;

public class LRUCacheMiss {
    public int lruCacheMisses(int num, List<Integer> input, int size) {
        List<Integer> list = new LinkedList<>();
        int count = 0;
        for(int i: input)
        {
            if(list.contains(i)) list.remove(new Integer(i));
            else
            {
                if(list.size() == size) list.remove(0);
                count++;
            }
            list.add(i);
        }
        return count;
    }

    public static void main(String[] args) {
        final LRUCacheMiss cache = new LRUCacheMiss();
        System.out.println(cache.lruCacheMisses(6, new ArrayList<>(Arrays.asList(1, 2, 1, 3, 1, 2)), 2));
    }
}
