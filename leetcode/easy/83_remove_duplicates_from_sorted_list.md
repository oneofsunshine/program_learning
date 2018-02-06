### Remove Duplicates from Sorted List

#### 1. Description:

>  Given a sorted linked list, delete all duplicates such that each element appear only *once*.

#### 2. Example:

```
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
```

#### 3.Solution(code):

```python
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        tmp = head
        if tmp == None:
            return []
        while tmp.next != None:
            if tmp.val == tmp.next.val:
                tmp.next = tmp.next.next
            else:
                tmp = tmp.next
                
        return head
```
#### 4.Analysis:
**算法时间复杂度:** O(N)

**题目大意:** 将链表中多余重复项去掉，结果为含所有不同项的最小链

**解题思路:** 和26题从有序数组中删除重复项类似，都要使结果序列为含所有不同项的最小序列，本题直接将重复项去掉即可

**体会:** 因有类似题目，有比较清晰的方向感