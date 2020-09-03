package com.company.codingscales.leetcode.concepts.dynamicProgramming;

public class KnightProbability {
    private static final int[][]dir = new int[][]{{-2,-1},{-1,-2},{1,-2},{2,-1},{2,1},{1,2},{-1,2},{-2,1}};
    private static double[][][] dp;

    public static double knightProbability(final int N, final int K, final int r, final int c) {
        dp = new double[N][N][K + 1];
        return recHelper(N,K,r,c);
    }

    public static double recHelper(final int N, final int K, final int r, final int c){
        if(r < 0 || r > N - 1 || c < 0 || c > N - 1) return 0;
        if(K == 0)  return 1;

        if(dp[r][c][K] != 0) return dp[r][c][K];

        double rate = 0;
        for(int i = 0; i < dir.length; i++) {
            rate += 0.125 * recHelper(N,K - 1,r + dir[i][0],c + dir[i][1]);
        }

        dp[r][c][K] = rate;
        return rate;
    }

    public static void main(final String[] args) {
        System.out.println(knightProbability(3, 2, 0, 0));
    }
}
