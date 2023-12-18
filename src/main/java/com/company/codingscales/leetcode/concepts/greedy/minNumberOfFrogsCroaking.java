package com.company.codingscales.leetcode.concepts.greedy;

public class minNumberOfFrogsCroaking {
    /**
     *                                                  i
     *                                      c r o a k c r o a k
     *
     *
     *                                      c   r   o   a   k
     *
     *                              count  0   1    2   3   4
     *                                     1
     *                                     0   1
     *                                     0   0    1
     *                                     0   0    0   1
     *                                     0   0    0   0   1
     *                                     1   0    0   0   1
     *                                     0   1    0   0   1
     *                                     0   0    1   0   1
     *                                     0   0    0   1   1
     *                                     0   0    0   0   2
     *
     *
     *
     *
     *                                     c r o a k c r o o k
     *
     *                                      c   r   o   a   k
     *
     *                              count  0   1    2   3   4
     *                                     1
     *                                     0   1
     *                                     0   0    1
     *                                     0   0    0   1
     *                                     0   0    0   0   1
     *                                     1   0    0   0   1
     *                                     0   1    0   0   1
     *                                     0   0    1   0   1
     *                                     0   -1    2   0   1 -> When we look at r's count it is decremented to -1 -> Meaning when you reach this o, there were no sufficient r's coming before - hence return -1
     *
     *
     *
     *                                    c r o a k c r o
     *
     *                                      c   r   o   a   k
     *
     *                              count  0   1    2    3   4
     *                                     1
     *                                     0   1
     *                                     0   0    1
     *                                     0   0    0   1
     *                                     0   0    0   0   1
     *                                     1   0    0   0   1
     *                                     0   1    0   0   1
     *                                     0   0    1   0   1 -> Frogs = 1, meaning last frog didn't complete croaking
     *
     *
     *                             Basically, conditions can be checked like follows, count except for k all should 0. No of K's count is no of frogs.
     *
     */
    public int minNumberOfFrogs(String A) {
        int[] count = new int[5];

        int maxFrogs = 0;
        int frogs = 0;

        for (char ch : A.toCharArray()) {
            int idx = "croak".indexOf(ch);
            count[idx]++;

            if (ch == 'c') {
                frogs++; // possibility of new frog
                maxFrogs = Math.max(maxFrogs, frogs);
                // since frogs count is decremented, need to store the max no of frogs seen during iteration
            } else if (ch == 'k') {
                int prevIdx = idx - 1;
                count[prevIdx]--;

                if (count[prevIdx] < 0) // you can only have a frog croaking, if previous letter is already there
                    return -1;

                frogs--;
            } else {
                int prevIdx = idx - 1;
                count[prevIdx]--;

                if (count[prevIdx] < 0) // you can only have a frog croaking, if previous letter is already there
                    return -1;
            }
        }

        return frogs == 0 ? maxFrogs : -1; // are all frogs croaking
    }
}

