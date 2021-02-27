package com.company.codingscales.interviews.microsoft;

import java.util.Arrays;

public class ColorButterFlies {
    public int solve(int pre, int n, int k, int [][] dp, int a){
        /* when n is 0 no positions to try  more and valid colors are filled */
        if(n==0) return 1;
        int ans = 0;
        /* Only first time previous color will be -1 otherwise we will have valid dp entry to check we already solved the problem */
        if(pre!=-1 && dp[pre][n]!=-1) return dp[pre][n];
        /* Try all possible color */
        for(int i=1;i<=k;i++){
            /* if pre color is same as current skip but exceptional color is ok */
            if(i==pre && pre!=a) continue;
            /*I am treating exceptional color separate but not needed */
            if(i==a) continue;
            /* The next sub problem becomes 1 less position to try */
            ans += solve(i,n-1,k,dp,a);
            ans%=1000000007; /* Mod check*/
        }
        ans+=solve(a,n-1,k,dp,a);
        ans%=1000000007;
        if(pre!=-1){ /* updated all the time except very first case where there is no valid previous color issue */
            dp[pre][n]=ans;
        }
        return ans;
    }

    public int getCount(int n, int k, int a) {
        int[][] dp = new int[k + 1][n + 1];
        for(int[] each : dp)
            Arrays.fill(each, -1);
        return solve(-1, n, k, dp, a);
    }
}
