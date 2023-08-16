import ListNode

class Solution:
    def partition(self, head: Optional[ListNode], x: int) -> Optional[ListNode]:
        curr = head

        new_head = ListNode()
        other_head = ListNode()

        prev = new_head
        other = other_head

        while curr != None:

            nxt = curr.next

            if curr.val < x:
                prev.next = curr
                prev = curr

                prev.next = None
            else:
                other.next = curr
                other = curr

                other.next = None

            curr = nxt

        prev.next = other_head.next

        return new_head.next