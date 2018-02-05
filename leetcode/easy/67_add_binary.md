### Add Binary

#### 1. Description:

> Given two binary strings, return their sum (also a binary string).
>
> For example,
> a = `"11"`
> b = `"1"`
> Return `"100"`.

#### 2. Solution (code):
```python
class Solution:
    def addBinary(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
        inta = int(a, 2)
        intb = int(b, 2)
        
        intc = format(inta + intb, "b")
        return str(intc)
```