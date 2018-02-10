### Add Digits

#### 1. Description:

> Given a non-negative integer `num`, repeatedly add all its digits until the result has only one digit.
>
> **Follow up:**
>
> Could you do it without any loop/recursion in O(1) runtime?

#### 2. Example:

```
Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
```

#### 3. Solution(code):

```python
class Solution:
    def addDigits(self, num):
        """
        :type num: int
        :rtype: int
        """
        # 根据 digits root: dr(n) = 1 + (num - 1) % (b - 1) //十进制中b = 10
        # -1 % 9 = 8 in python3
        if num == 0:
            return 0
        return 1 + (num - 1) % 9
```

