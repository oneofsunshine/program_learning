### Plus One

#### 1. Description:

> Given a non-negative integer represented as a **non-empty** array of digits, plus one to the integer.
>
> You may assume the integer do not contain any leading zero, except the number 0 itself.
>
> The digits are stored such that the most significant digit is at the head of the list.

#### 2. Solution (code):
```python
class Solution:
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        length = len(digits)
        digits[length -1] = digits[length -1] + 1
        
        for i in range(length)[::-1]:
            if digits[i] == 10:
                if i != 0:
                    digits[i] = 0
                    digits[i - 1] = digits[i - 1] + 1
                else:
                    digits[0] = 0
                    digits.insert(0, 1)
                        
        return digits
```