package com.company.codingscales.leetcode.concepts.linkedList;

public class RemoveElementsFromLinkedList {
    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode();
        newHead.next = head;

        ListNode prev = newHead;

        ListNode curr = head;

        while (curr != null) {
            if (curr.val == val) {
                while (curr != null && curr.val == val) {
                    curr = curr.next;
                }

                prev.next = curr;
                prev = curr;
            }

            prev = curr;
            curr = curr == null ? null : curr.next;
        }

        return newHead.next;
    }
}
