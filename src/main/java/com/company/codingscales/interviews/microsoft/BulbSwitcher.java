package com.company.codingscales.interviews.microsoft;

public class BulbSwitcher {
    public int numTimesAllBlue(final int[] light) {
        // o(n)
        int rightMostLit = 0;
        int res = 0;
        for (int i = 0; i < light.length; i++) {
            rightMostLit = Math.max(rightMostLit, light[i]);
            if (i + 1 == rightMostLit)
                res++;
        }
        return res;
    }


}
