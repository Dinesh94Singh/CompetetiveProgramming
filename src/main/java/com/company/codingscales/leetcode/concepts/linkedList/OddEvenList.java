package com.company.codingscales.leetcode.concepts.linkedList;

public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode();
        ListNode even = new ListNode();

        ListNode newHead = odd;
        ListNode dummy = even;

        ListNode curr = head;

        while (curr != null) {
            odd.next = curr;
            even.next = curr.next;

            odd = odd.next;
            even = even.next;
            curr = curr.next != null ? curr.next.next : null;
        }

        odd.next = dummy.next;

        return newHead.next;
    }
}
