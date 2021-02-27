package com.company.codingscales.leetcode.concepts.linkedList;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;
        ListNode t1 = head;
        ListNode t2 = head.next;

        while (t2 != null) {
            t1 = t1.next;
            t2 = t2.next != null ? t2.next.next : null;
        }

        t2 = ReverseListNode.reverseList(t1);
        t1 = head;

        while (t1 != null && t2 != null) {
            if (t1.val != t2.val)
                return false;
            t1 = t1.next;
            t2 = t2.next;
        }

        return true;

    }
}
