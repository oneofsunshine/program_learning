### Delete Node in a Linked List

#### 1. Description:

> Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
>
> Supposed the linked list is `1 -> 2 -> 3 -> 4` and you are given the third node with value `3`, the linked list should become `1 -> 2 -> 4` after calling your function.

#### 2. Solution (code):
```python
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
```