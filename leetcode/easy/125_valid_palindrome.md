### Valid Palindrome

#### 1. Description:

> Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
>
> **Note:**
> Have you consider that the string might be empty? This is a good question to ask during an interview.
>
> For the purpose of this problem, we define empty string as valid palindrome.

#### 2. Example:

```
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.
```

#### 3. Solution(code):

```python
class Solution:
    def isPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        # extract alphanumeric characters
        alnum_str = ''.join([i for i in s if i.isalnum()])
    
        # decide if it is a palindrome
        if alnum_str.lower() == alnum_str[::-1].lower() or alnum_str == []:
            return True
        else:
            return False
```

```python
class Solution:
    def isPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        pattern = re.compile('[\\W_]+')
        A=pattern.sub('', s.lower())
        return A==A[::-1]
```

#### 4. Analysis:

本题关键点是去除字符串的非数字和字母字符，应使用正则表达式。

对python3的正则还不熟悉，在此留白。之后补充整理后的python3正则表达式。