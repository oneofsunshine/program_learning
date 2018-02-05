### Reverse Integer
#### 1. Description:
> Given a 32-bit signed integer, reverse digits of an integer.
>
> **Note:**
> Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
#### 2.Example:
Example 1:
```
Input: 123
Output:  321
```
Example 2:
```
Input: -123
Output: -321
```
Example 3:
```
Input: 120
Output: 21
```
#### 3. Solution (code):
```python
class Solution:
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        if x > 0:
            res = str(x)[::-1]
            if is_overflow(int(res)):
                return 0
            else:
                return int(res)
        elif x == 0:
            return 0
        else:
            res = str(-x)[::-1]
            if is_overflow(-int(res)):
                return 0
            else:
                return -int(res)

def is_overflow(x):
    if x < -2147483648 or x > 2147483648:
        return 1
    else:
        return 0
```
