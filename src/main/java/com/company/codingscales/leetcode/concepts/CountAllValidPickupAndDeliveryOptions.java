package com.company.codingscales.leetcode.concepts;

import javafx.util.Pair;

import java.util.HashMap;

public class CountAllValidPickupAndDeliveryOptions {
    private int MOD = 1_000_000_007;
    HashMap<Pair<Integer, Integer>, Long> map;

    public int countOrders(int n) {
        // 2 leftOverPickups
        // 2 leftOverDeliveries

        // cannot deliver without picking up

        // find all ways of picking up

        map = new HashMap<>();
        return (int) dfs(n, n);
    }

    private long dfs(int leftOverPickups, int leftOverDeliveries) {
        if (leftOverPickups == 0 && leftOverDeliveries == 0) {
            return 1;
        }

        if (leftOverPickups < 0 || leftOverDeliveries < 0 || leftOverPickups > leftOverDeliveries) {
            return 0;
        }

        Pair<Integer, Integer> p = new Pair<>(leftOverPickups, leftOverDeliveries);
        if (map.containsKey(p)) {
            return map.get(p);
        }

        // picking up a order - amount of left over pickups can be selected in left over pickup ways
        long total = leftOverPickups * dfs(leftOverPickups - 1, leftOverDeliveries);

        total = total % MOD;

        // delivering a order - amount of completed deliveries at this stage * left over stuff
        total += (leftOverDeliveries - leftOverPickups) * dfs(leftOverPickups, leftOverDeliveries - 1);

        total = total % MOD;

        map.put(p, total);
        return total;
    }
}
