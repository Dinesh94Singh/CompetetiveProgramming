package com.company.codingscales.leetcode.concepts.linkedList;

public class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = head;

        int k = n;
        while (p2 != null && k > 0) {
            p2 = p2.next;
            k--;
        }

        if (p2 == null)
            return p1.next;

        ListNode prev = null;
        while (p2 != null) {
            prev = p1;
            p1 = p1.next;
            p2 = p2.next;
        }

        if (prev != null)
            prev.next = p1.next;
        else
            return null;
        return head;
    }
}
