package com.company.codingscales.leetcode.concepts.greedy;

import java.util.Arrays;

/**
 * You are only supposed to accommodate 2 people in the boat. If you want to accommodate multiple people,
 * that would be a knapsack problem
 */
public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int i = 0, j = people.length - 1, ans = 0;
        while(i <= j) {
            ans++;
            if (people[i] + people[j] <= limit) {
                i++;
            }
            j--;
        }

        return ans;

    }
}
