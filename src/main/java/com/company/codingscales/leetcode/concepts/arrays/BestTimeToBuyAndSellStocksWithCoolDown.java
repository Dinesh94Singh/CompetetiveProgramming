package com.company.codingscales.leetcode.concepts.arrays;

import javafx.util.Pair;

import java.util.HashMap;

public class BestTimeToBuyAndSellStocksWithCoolDown {
    public int maxProfit(final int[] prices) {
        return dfs(prices, new HashMap<Pair<Integer, Boolean>, Integer>(), 0, true);
    }

    public Integer dfs(final int[] prices, final HashMap<Pair<Integer, Boolean>, Integer> cache, final Integer index, final Boolean canBuy) {
        if (index >= prices.length) return 0;

        final Pair<Integer, Boolean> p = new Pair<>(index, canBuy);

        if (cache.containsKey(p)) {
            return cache.get(p);
        }

        // Buy/Sell (or) skip
        int buyOrSell = 0;
        if (canBuy) {
            buyOrSell =  -1 * prices[index] +  dfs(prices, cache, index + 1, !canBuy);
        } else {
            buyOrSell = prices[index] +  dfs(prices, cache, index + 2, !canBuy);
        }

        final int skip = dfs(prices, cache, index + 1, canBuy);

        cache.put(p, Math.max(buyOrSell, skip));
        return cache.get(p);
    }
}
