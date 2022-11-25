package com.company.codingscales.leetcode.concepts.linkedList;

public class LinkedListCycleDetection2 {
    ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        if (head == null || head.next == null)
            return null;

        do {
            slow = slow.next;
            fast = fast.next.next;
        } while (fast != null && fast.next != null && slow != fast);

        if (fast == null || fast.next == null)
            return null;

        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
