class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        l = []
        for i in s:
            if i == '(' or i == '{' or i =='[':
                l.append(i)
            elif i == ')':
                if len(l) == 0 or l.pop() != '(':
                    return False
            elif i == ']':
                if len(l) == 0 or l.pop() != '[':
                    return False
            else:
                if len(l) == 0 or l.pop() != '{':
                    return False
        
        return len(l) == 0
