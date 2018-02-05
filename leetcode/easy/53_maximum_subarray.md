### Maximum Subarray

#### 1. Description:

> Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
>
> For example, given the array `[-2,1,-3,4,-1,2,1,-5,4]`,
> the contiguous subarray `[4,-1,2,1]` has the largest sum = `6`.

#### 2. Solution (code):
```python
class Solution:
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 1:
            return nums[0]
        tmp1 = nums[0]
        tmp2 = nums[0] 
        for i in nums[1:]:
            tmp1 = max(tmp1 + i, i)
            tmp2 = max(tmp1, tmp2)
        return tmp2
```