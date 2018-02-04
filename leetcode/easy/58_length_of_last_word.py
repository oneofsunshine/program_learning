class Solution:
    def lengthOfLastWord(self, s):
        """
        :type s: str
        :rtype: int
        """
        return len(s.strip().split(" ")[-1])
        # str.strip([chars]) 用于移除字符串头尾指定的字符（默认为空格）。
