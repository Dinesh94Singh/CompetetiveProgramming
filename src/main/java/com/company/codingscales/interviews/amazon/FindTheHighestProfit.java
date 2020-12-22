package com.company.codingscales.interviews.amazon;

public class FindTheHighestProfit {
    int findHighestProfit(int numSuppliers, int[] inventory, int orders) {
        int profit = 0;
        int len = inventory.length; // numSuppliers
        int i = len - 1;

        while (orders > 0) {
            if (i > 0 && inventory[i] == inventory[i - 1]) {
                i = i - 1;
            }
            if (orders < len - i) {
                profit += orders * inventory[i];
                return profit;
            }

            int val = (len - i) * inventory[i];
            orders -= len - i;
            profit += val;
            inventory[i] -= 1;
        }
        return profit;
    }

    int findHighestProfitAnother(int[] nums, int size, int orders) {
        if(nums == null || nums.length == 0) return 0;
        int maxNum = Integer.MIN_VALUE;
        for(int num : nums)
            maxNum = Math.max(num, maxNum);
        int[] array = new int[maxNum + 1];
        for(int num : nums)
            array[num]++;
        int res = 0;
        for(int i = maxNum; i >= 1 && orders > 0; i--) {
            res += (orders > array[i]) ? array[i] * i : orders * i;
            array[i-1] += array[i];
            orders -= array[i];
        }
        return res;
    }
}
