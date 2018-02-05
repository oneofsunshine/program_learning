### Palindrome Number
#### 1. Description:

> Determine whether an integer is a palindrome. Do this without extra space.

#### 2. Solution (code):
```python
class Solution(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        if x < 0 or (x % 10 == 0 and x != 0):
            return False
        
        rev = 0
        while x > rev:
            rev = rev * 10 + x % 10
            x /= 10 
        
        return x == rev or x == rev / 10
```