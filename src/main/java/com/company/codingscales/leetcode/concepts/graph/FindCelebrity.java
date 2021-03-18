package com.company.codingscales.leetcode.concepts.graph;

public class FindCelebrity {
    static boolean knows(int a, int b) {
        return true;
    }

    int findCeleb(int n) {
        int curr = 0; // assume, celeb is 0th person

        for (int i = 0; i < n; i++) {
            if (knows(curr, i)) // if potential celeb knows someone, then he couldnt be celeb, so mark pottential celeb i -> Similar to gas station
                curr = i;
        }

        for (int j = 0; j < n; j++) {
            if (j == curr)
                continue;
            if (!knows(j, curr) || knows(curr, j)) // if any1 doesn't know our pottential celeb or celeb knows some1
                return -1;
        }
        return curr; // no celeb found
    }
}
