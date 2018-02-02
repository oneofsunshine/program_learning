# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def deleteNode(self, node):
        """
        :type node: ListNode
        :rtype: void Do not return anything, modify node in-place instead.
        """
        node.val = node.next.val
        node.next = node.next.next
        
        
/*
 * 因find index == keyValue时，不能在将前一个的下一个直接指向下一个，故采用过度方法
 * 1 -> 2 -> 3 -> 4 -> 5 删除3,　找到3 后，让3的位置等于4,　让那个位置的next = next->next，同样实现移除次节点
 */
