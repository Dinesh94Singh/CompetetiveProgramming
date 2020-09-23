package com.company.codingscales.leetcode.concepts.design;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class PhoneDirectory {
    HashSet<Integer> usedNumbers;
    Queue<Integer> availableList;

    /**
     * Initialize your data structure here
     *
     * @param maxNumbers - The maximum numbers that can be stored in the phone directory.
     */
    public PhoneDirectory(final int maxNumbers) {
        usedNumbers = new HashSet<>();
        availableList = new LinkedList<Integer>();

        for (int i = 0; i < maxNumbers; i++) {
            availableList.offer(i);
        }
    }

    /**
     * Provide a number which is not assigned to anyone.
     *
     * @return - Return an available number. Return -1 if none is available.
     */
    public int get() {
        if (availableList.isEmpty())
            return -1;

        final int x = availableList.poll();
        usedNumbers.add(x);
        return x;
    }

    /**
     * Check if a number is available or not.
     */
    public boolean check(final int number) {
        return !usedNumbers.contains(number);
    }

    /**
     * Recycle or release a number.
     */
    public void release(final int number) {
        if (usedNumbers.remove(number)) {
            availableList.offer(number);
        }
    }
}

// Another Good Solution, which avoids filling the linked list -> Prefer this
/*
    public PhoneDirectory(int maxNumbers) {
        max = maxNumbers;
        used = new HashSet<>();
        free = new LinkedList<>();
    }

    public int get() {
        if(used.size() == max) return -1;
        Integer ret = free.isEmpty() ? used.size() : free.poll();
        used.add(ret);
        return ret;
    }

    public boolean check(int number) {
        return !used.contains(number);
    }

    public void release(int number) {
        if(used.remove(number))
            free.add(number);
    }
*/