### Perfect Number

#### 1. Description:

> We define the Perfect Number is a **positive** integer that is equal to the sum of all its **positive** divisors except itself.
>
> Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
>
> **Note:** The input number **n** will not exceed 100,000,000. (1e8)

#### 2. Example:

```
Input: 28
Output: True
Explanation: 28 = 1 + 2 + 4 + 7 + 14
```

#### 3. Solution(code):

```python
class Solution:
    def checkPerfectNumber(self, num):
        """
        :type num: int
        :rtype: bool
        """
        if num <= 0:
            return False
        res = 0
        for i in range(1, int(num ** 0.5) + 1):
            if num % i == 0:
                res += i
                if i * i != num:
                    res += num / i
        return res - num == num # 因为i = 1时 1 * 1 != num加上了一个 num / 1，而perfect number不包括num,所以最后应减去num
```

#### 4. Analysis:

**时间复杂度:** O(sqrt(n)

**题目大意:** 给出一个数字，判断此数字是不是完美数（除本身外所有因子的和等于本身）

**解题思路:** 找出在[1, sqrt(num)]间num的因数，若某因数不等于sqrt(num)，则其在(sqrt(num), num]中有另一个因数与此因数同时出现

**体会:** 上来打了一套O(N)的无脑Solution，直接从头到位判断，是因数的就加起来，结果超时了，看了一下solution，第一个就是我那种。。。然后看到第三种，想起以前好像是这么做的。哎，好久没怎么做题，很多方法都忘了，需要重新积累了。