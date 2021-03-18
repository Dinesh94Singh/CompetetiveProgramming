package com.company.codingscales.leetcode.concepts.dynamicProgramming.knapsack;

public class TargetSum {
    public int findTargetSumWaysTopDown(int[] nums, int target) {
        // 2 signs => +, -
        // if index == N && total == target => return 1 else return 0
        // To memoize, we can use dp[nums.length][2001]; hoping, it won't go beyond it. 0 at half of 2000. Or add 1000 offset, to introduce shift
        return dfs(0, 0, target, nums);
    }

    private int dfs(int index, int total, int target, int[] nums) {
        if (index == nums.length) {
            if (total == target)
                return 1;
            return 0;
        }


        int c1 = dfs(index + 1, total + nums[index], target, nums);
        int c2 = dfs(index + 1, total - nums[index], target, nums);

        return c1 + c2;
    }

    // this function is exactly similar to what we have in 'Count of Subset Sum' problem.
    // Use this.
    private int targetSum(int[] num, int sum) {
        int n = num.length;
        int[] dp = new int[sum + 1];
        dp[0] = 1;

        // with only one number, we can form a subset only when the required sum is equal to the number
        for(int s=1; s <= sum ; s++) {
            dp[s] = (num[0] == s ? 1 : 0);
        }

        // process all subsets for all sums
        for(int i=1; i < num.length; i++) {
            for(int s=sum; s >= 0; s--) {
                if(s >= num[i])
                    dp[s] += dp[s-num[i]];
            }
        }

        return dp[sum];
    }

    public int findTargetSumWaysBottomUp(int[] nums, int target) {
        int[][] dp = new int[nums.length][2001]; // given in the statement, the total doesn't exceed 1000. Since we need to consider, both -ve and +ve, we are using 2000

        dp[0][nums[0] + 1000] = 1;
        dp[0][-nums[0] + 1000] += 1; // += because, if the nums[0] is 0, then the dp should hold 2, not 1.

        for(int i = 1; i < nums.length; i++) {
            for(int sum = -1000; sum < 1001; sum++) {
                if (dp[i - 1][sum + 1000] > 0) {
                    dp[i][sum + 1000 + nums[i]] += dp[i - 1][sum + 1000];
                    dp[i][sum + 1000 - nums[i]] += dp[i - 1][sum + 1000];
                }
            }
        }

        return target > 1000 ? 0 : dp[nums.length - 1][target + 1000];
    }

    public int findTargetSumWaysBottomUpOptimized(int[] nums, int target) {
        int[] dp = new int[2001];
        dp[nums[0] + 1000] = 1;
        dp[-nums[0] + 1000] += 1;
        for (int i = 1; i < nums.length; i++) {
            int[] next = new int[2001];
            for (int sum = -1000; sum <= 1000; sum++) {
                if (dp[sum + 1000] > 0) {
                    next[sum + nums[i] + 1000] += dp[sum + 1000];
                    next[sum - nums[i] + 1000] += dp[sum + 1000];
                }
            }
            dp = next;
        }

        return target > 1000 ? 0 : dp[target + 1000];
    }
}
