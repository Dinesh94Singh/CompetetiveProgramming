package com.company.codingscales.interviews.amazon;

import java.util.List;

public class UtilizationChecks {
    final static double LIMIT = 2 * 10e8; // 100000000
    public static int finalInstances(int instances, List<Integer> averageUtilization) {
        int i = 0;
        int n = averageUtilization.size();
        while (i < n) {
            int curr = averageUtilization.get(i);
            if (curr < 25 && instances > 1) {
                instances = instances % 2 == 0 ? instances / 2 : (instances / 2 + 1);
                i+= 10;
                i++;
            } else if (curr > 60 && instances  * 2 < LIMIT) {
                instances *= 2;
                i+= 10;
                i++;
            } else {
                i++;
            }
        }

        return instances;
    }
}
