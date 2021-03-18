package com.company.codingscales.leetcode.concepts.linkedList;

public class LinkedListCycleDetection2 {
    ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;
        ListNode p1 = head;
        ListNode p2 = head;

        boolean cycleFound = false;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;

            if (p1 == p2) {
                cycleFound = true;
                break;
            }
        }

        if (!cycleFound)
            return null;

        p1 = head;
        p2 = p2;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }
}
