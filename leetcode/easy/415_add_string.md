### Add Strings
#### 1. Dsecription:
> Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
> Note:
>
> 1. The length of both num1 and num2 is < 5100.
> 2. Both num1 and num2 contains only digits 0-9.
> 3. Both num1 and num2 does not contain any leading zero.
> 4. You must not use any built-in BigInteger library or convert the inputs to integer directly.
#### 2. Solution(code):
```python
class Solution:
    def addStrings(self, num1, num2):
        """
        :type num1: str
        :type num2: str
        :rtype: str
        """
        l1 = len(num1) - 1
        l2 = len(num2) - 1
        carry = 0
        num = 0
        res = ""
        while l1 >= 0 or l2 >= 0:
            tmp1 = 0
            tmp2 = 0
            if l1 >= 0:
                tmp1 = int(num1[l1])
            if l2 >= 0:
                tmp2 = int(num2[l2])
            num = tmp1 + tmp2 + carry
            carry = num // 10
            num = num % 10
            res = str(num) + res
            l1 -= 1
            l2 -= 1
            
        if carry > 0:
            res = "1" + res
        return res
```

#### 3. Analysis:

**算法时间复杂度:** O(N)

**题目大意:** 给出两个以字符串表示的长整数，返回这两个长整数的和

**解题思路:** 按加法算法，就从低位向高位处理两个字符串，结果的第`i`位为（num1[i] + num2[i] + 低一位的进位）的个位，若一串处理完另一串还未处理完，处理完的那一串高位全为0

**体会:** 以前的思路是把两个字符串倒过来，先把对应位加起来，再处理某位>9的情况，代码长度长，时间复杂度高，在discuss中看到这种算法，思路简单效率也还可以，以后这类题都可以换成这种思路。