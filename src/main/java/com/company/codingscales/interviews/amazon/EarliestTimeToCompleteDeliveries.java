package com.company.codingscales.interviews.amazon;

import java.util.Arrays;

public class EarliestTimeToCompleteDeliveries {
    public int earliestTimeToComplete(int noOfBuildings, int[] buildingOpenTime, int[] offloadTime) {
        Arrays.sort(buildingOpenTime); // we will sort buildingOpenTime, so that we get earliest time first.
        Arrays.sort(offloadTime); // and so off load time.

        int res = 0;
        for (int i = 0; i < noOfBuildings; i++) {
            // now we know each building has 4 dock, mean we can assume noOfBuildings =
            // noOfBuildings * 4;
            // and we can off load 4 item at a time.
            int idx = noOfBuildings * 4 - i * 4 - 1;
            res = Math.max(res, buildingOpenTime[i] + offloadTime[idx]); // building with earliest time first + max off load time
        }

        return res;
    }
}
