package com.company.codingscales.interviews.microsoft;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class JumpGame3 {
    public static void main(final String[] args) {
        final int[] nums = {3, 4, 2, 3, 0, 3, 1, 2, 1};
        final int start = 7;
        System.out.println(canReach0BFS(nums, start));
    }

    private static boolean canReach0BFS(final int[] nums, final int start) {
        final Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        final Set<Integer> visited = new HashSet<>();
        while(!q.isEmpty()) {
            final int cur = q.poll();
            if(nums[cur] == 0)
                return true;
            if(!visited.contains(cur)) {
                visited.add(cur);
                if(cur - nums[cur] >= 0)
                    q.offer(cur - nums[cur]);
                if(cur + nums[cur] < nums.length)
                    q.offer(cur + nums[cur]);
            }
        }
        return false;
    }
}
