package com.company.codingscales.leetcode.concepts.linkedList;

public class LinkedListPalindrome {
    private static ListNode reverse(ListNode head) {
        ListNode dummy = null;
        ListNode prev = null;
        while (head != null) {
            dummy = head.next;
            head.next = prev;

            prev = head;
            head = dummy;
        }

        return prev;
    }

    public static boolean isPalindrome(final ListNode head) {
        if (head == null)
            return true;

        if (head.next == null)
            return true;

        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;

        while (fast != null) {
            prev = slow;
            fast = fast.next != null ? fast.next.next : null;
            slow = slow.next;
        }

        prev.next = null; // reverse till prev

        ListNode p1 = reverse(head);

        if (length % 2 != 0)
            p1 = p1.next;

        while (slow != null && p1 != null){
            if (slow.val != p1.val)
                return false;
            slow = slow.next;
            p1 = p1.next;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        // System.out.println(isPalindrome(head));

        head = new ListNode(1);
        head.next = new ListNode(0);

        // System.out.println(isPalindrome(head)); // should return false;

        head = new ListNode(1);
        head.next = new ListNode(1);

        // System.out.println(isPalindrome(head));

        head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);

        System.out.println(isPalindrome(head)); // should return true
    }
}
