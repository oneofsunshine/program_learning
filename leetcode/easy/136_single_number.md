### Single Number

#### 1. Description:

> Given an array of integers, every element appears *twice* except for one. Find that single one.
>
> **Note:**
> Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

#### 2. Solution(code):

```python
class Solution:
    def singleNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # 2∗(a+b+c)−(a+a+b+b+c)=c
        return 2 * sum(set(nums)) - sum(nums)
```

