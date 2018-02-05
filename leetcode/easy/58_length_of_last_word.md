### Length of Last Word

#### 1. Description:

> Given a string *s* consists of upper/lower-case alphabets and empty space characters `' '`, return the length of last word in the string.
>
> If the last word does not exist, return 0.
>
> **Note:** A word is defined as a character sequence consists of non-space characters only.

#### 2.Example:

```
Input: "Hello World"
Output: 5
```

#### 3. Solution (code):
```python
class Solution:
    def lengthOfLastWord(self, s):
        """
        :type s: str
        :rtype: int
        """
        return len(s.strip().split(" ")[-1])
        # str.strip([chars]) 用于移除字符串头尾指定的字符（默认为空格）。
```