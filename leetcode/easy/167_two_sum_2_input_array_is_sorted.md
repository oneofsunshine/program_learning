### Two Sum II - Input array is sorted

#### 1. Description:

> Given an array of integers that is already **sorted in ascending order**, find two numbers such that they add up to a specific target number.
>
> The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
>
> You may assume that each input would have *exactly* one solution and you may not use the *same* element twice.

#### 2. Example:

```
Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
```

#### 3. Solution(code):

```python
class Solution:
    def twoSum(self, numbers, target):
        """
        :type numbers: List[int]
        :type target: int
        :rtype: List[int]
        """
        res = []
        left = 0
        right = len(numbers) - 1
        while left < right:
            sum = numbers[left] + numbers[right]
            if sum == target:
                return left + 1, right + 1
            elif sum > target:
                right -= 1
            else:
                left += 1
```

#### 4. Analysis:

**时间复杂度:** O(N)

**题目大意:** 给出一个有序数组，找出其中和为给定值的两个数，返回其位置

**解题思路:** 因为数组为有序数组，可仿照二分查找，从数组两端开始，若左右和等于target，返回左右位置，若左右和>target，右端-=1，若左右和<target，左端+=1。

**体会:** 这类题目和基础算法的思想很接近，若数组无序，与排序算法中的冒泡排序和选择排序的操作类似，若有序，则与二分查找的步骤类似。