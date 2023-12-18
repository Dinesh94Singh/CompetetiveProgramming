package com.company.codingscales.leetcode.concepts.dynamicProgramming;

public class IPO {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // work on k projects before IPO
        // maximize total capital after finishing k distinct projects

        // N projects total - which have Profits[i] for each project
        // You need Capital[i] to start that project

        // intially we have w capital to start with

        // pick at-most k projects to maximize final Capital

        return dfs(k, w, profits, capital, 0);
    }

    private int dfs(int k, int w, int[] profits, int[] capital, int idx) {
        if (idx == profits.length || k == 0)
            return 0;

        int maximumProfit = 0;

        if (capital[idx] <= w) {
            int new_capital = w - capital[idx] + profits[idx];
            int c1 = profits[idx] + dfs(k - 1, new_capital, profits, capital, idx + 1);
            maximumProfit = Math.max(maximumProfit, c1);
        }

        int c2 = dfs(k, w, profits, capital, idx + 1); // don't consider this project
        maximumProfit = Math.max(maximumProfit, c2);

        return maximumProfit;
    }

    public static void main(String[] args) {
        IPO s = new IPO();
        System.out.println(s.findMaximizedCapital(1, 2, new int[] { 1, 2, 3 }, new int[] { 1, 1, 2 }));
    }
}
