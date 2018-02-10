### Count Primes

#### 1. Description:

>  Count the number of prime numbers less than a non-negative number, **n**.

#### 2. Solution(code):

```python
class Solution:
    def countPrimes(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n < 3:
            return 0
        nums = [True] * n
        nums[:2] = [False] * 2
        for i in range(2, int(n ** 0.5) + 1):
            if nums[i]:
                nums[i * i: n: i] = [False] * len(nums[i * i: n: i])
        return sum(nums)
```

#### 3. Analysis:

**时间复杂度:** O(N)

**题目大意:** 给出一个整数n, 求(1, n)质数个数

**解题思路:** 创建一个大小为n的bool数组，bool值代表相应位是否为质数，通过找出合数置False，数组中True的个数即为质数的个数

**体会:** 我本来的思路是写个函数判断素数，然后遍历(1,n)统计期中质数个数，时间复杂度太高，结果超时。后在discuss中看到很多都是这种算法，就采用这种算法，算是积累经验了。