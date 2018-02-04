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
