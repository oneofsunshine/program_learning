### Excel Sheet Column Title

#### 1. Description:

> Given a positive integer, return its corresponding column title as appear in an Excel sheet.

#### 2. Example:

```
    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
```

#### 3. Solution(code):

```python
class Solution:
    def convertToTitle(self, n):
        """
        :type n: int
        :rtype: str
        """
        res = []
        while n > 0:
            res.append((n - 1) % 26) 
            n = (n - 1) // 26
        res.reverse()
        s = ""
        for i in res:
            s += chr(i + 65)
        return s
```

#### 4. Analysis:

**时间复杂度:** O(N)

**题目大意:** 给出一个数字将其以26为模转化为字母

**解题思路:** 因数字模为26，故将数字减一，令其为zero-based，再将数字转化为26进制，每位再按规则转化为大写字母

**体会:** 本题为进制转换的变形，需注意的是起始位应对应0