package com.company.codingscales.leetcode.concepts.linkedList;

public class IntersectionOfLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1 = 0;
        int l2 = 0;

        ListNode curr = headA;
        while (curr != null) {
            curr = curr.next;
            l1++;
        }

        curr = headB;
        while (curr != null) {
            curr = curr.next;
            l2++;
        }

        int diff = 0;
        ListNode t1 = headA;
        ListNode t2 = headB;

        System.out.println(l1 + " " + l2 + " : " + (l2 - l1));

        if (l1 < l2) {
            diff = l2 - l1;
            int i = 0;
            while (i < diff) {
                t2 = t2.next;
                i++;
            }
        } else {
            diff = l1 - l2;
            int i = 0;
            while (i < diff) {
                t1 = t1.next;
                i++;
            }
        }

        while (t1 != null && t2 != null) {
            if (t1 == t2) {
                return t1;
            } else {
                t1 = t1.next;
                t2 = t2.next;
            }
        }

        return null;
    }
}
