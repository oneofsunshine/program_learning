# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        if l1 == None:
            return l2
        elif l2 == None:
            return l1
        
        head = ListNode(-1)
        p1 = l1
        p2 = l2
        p3 = head
        while p1 and p2:
            if p1.val > p2.val:
                p3.next = p2
                p2 = p2.next
                p3 = p3.next
            else:
                p3.next = p1
                p1 = p1.next
                p3 = p3.next
        if p2 == None:
            p3.next = p1
            return head.next
        else:
            p3.next = p2
            return head.next
