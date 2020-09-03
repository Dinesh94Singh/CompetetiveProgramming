package com.company.codingscales.leetcode.concepts.arrays;

import java.util.HashMap;

public class BestTimeToBuyAndSellStocksWithCoolDown {
    public static class Pair {
        public int first;
        public Boolean second;

        Pair(final int first, final Boolean second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(final Object obj) {
            if (this == obj)
                return true;

            if (obj == null || obj.getClass()!= this.getClass())
                return false;

            final Pair geek = (Pair) obj;

            return (geek.first == this.first && geek.second == this.second);
        }

        @Override
        public int hashCode() {
            return this.first;
        }
    }

    public int maxProfit(int[] prices) {
        return dfs(prices, new HashMap<Pair, Integer>(), 0, true);
    }

    public Integer dfs(int[] prices, HashMap<Pair, Integer> cache, Integer index, Boolean canBuy) {
        if (index >= prices.length) return 0;

        Pair p = new Pair(index, canBuy);

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

        int skip = dfs(prices, cache, index + 1, canBuy);

        cache.put(p, Math.max(buyOrSell, skip));
        return cache.get(p);
    }
}
