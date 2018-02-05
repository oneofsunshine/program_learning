### Count and Say

#### 1. Description:

> The count-and-say sequence is the sequence of integers with the first five terms as following:
>
> ```
> 1.     1
> 2.     11
> 3.     21
> 4.     1211
> 5.     111221
>
> ```
>
> `1` is read off as `"one 1"` or `11`.
> `11` is read off as `"two 1s"` or `21`.
> `21` is read off as `"one 2`, then `one 1"` or `1211`.
>
> Given an integer *n*, generate the *n*th term of the count-and-say sequence.
>
> Note: Each term of the sequence of integers will be represented as a string.

#### 2.Example:

**Example 1:**

```
Input: 1
Output: "1"

```

**Example 2:**

```
Input: 4
Output: "1211"
```

#### 3. Solution (code):
```
class Solution:
    def countAndSay(self, n):
        """
        :type n: int
        :rtype: str
        """
        s = "1"
        for i in range(1, n):
            tmp = s
            s = count(tmp)
        return s
def count(string):
    str1 = ""
    c = string[0]
    num = 1
    for j in range(1, len(string)):
        if string[j] == c:
            num = num + 1
        else:
            str1 = str1 + str(num) + c
            num = 1
            c = string[j]
    str1 = str1 + str(num) + c
    return str1
```