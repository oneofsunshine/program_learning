### Search Insert Position

#### 1. Description:

> Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
>
> You may assume no duplicates in the array.

#### 2.Example:

**Example 1:**

```
Input: [1,3,5,6], 5
Output: 2

```

**Example 2:**

```
Input: [1,3,5,6], 2
Output: 1

```

**Example 3:**

```
Input: [1,3,5,6], 7
Output: 4

```

**Example 4:**

```
Input: [1,3,5,6], 0
Output: 0
```

#### 3. Solution (code):
```python
class Solution:
    def searchInsert(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        nums.append(target)
        nums.sort()
        return nums.index(target)
```