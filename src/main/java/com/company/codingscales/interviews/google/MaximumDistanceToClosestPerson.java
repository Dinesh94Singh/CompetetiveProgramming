package com.company.codingscales.interviews.google;

import com.company.codingscales.templates.LeetCodeInputHelpers;

import java.util.*;
import java.util.stream.Collectors;

public class MaximumDistanceToClosestPerson {
    public int maxDistanceToPerson(int[] s) {
        List<Integer> seats = Arrays.stream(s).boxed().collect(Collectors.toList());
        List<Integer> ones = new ArrayList<>();
        for(int i = 0; i < seats.size(); i++) {
            if (seats.get(i) == 1) {
                ones.add(i);
            }
        }

        int prevIndex = ones.get(0);
        int dist = Integer.MIN_VALUE;

        for(int i = 1; i < ones.size(); i++) {
            int currentIndex = ones.get(i);
            int diff = currentIndex - prevIndex;

            if (dist < (diff / 2)) {
                dist = (diff / 2);
            }
            prevIndex = currentIndex;
        }

        int diff = seats.size() - ones.get(ones.size() - 1) - 1;
        if (dist < diff) {
            dist = diff;
        }

        if (diff < ones.get(0)) {
            return ones.get(0);
        }

        return dist;
    }

    public static void main(String[] args) {
        MaximumDistanceToClosestPerson sol = new MaximumDistanceToClosestPerson();
        System.out.println(sol.maxDistanceToPerson(LeetCodeInputHelpers.stringToIntArray("[1,0,0,0,1,0,1]")));
        System.out.println(sol.maxDistanceToPerson(LeetCodeInputHelpers.stringToIntArray("[0,0,0,0,1,0,1]")));
        System.out.println(sol.maxDistanceToPerson(LeetCodeInputHelpers.stringToIntArray("[1,0,0,0]")));
        System.out.println(sol.maxDistanceToPerson(LeetCodeInputHelpers.stringToIntArray("[0,1]")));
    }
}
