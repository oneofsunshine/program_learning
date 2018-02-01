class Solution:
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        if x > 0:
            res = str(x)[::-1]
            if is_overflow(int(res)):
                return 0
            else:
                return int(res)
        elif x == 0:
            return 0
        else:
            res = str(-x)[::-1]
            if is_overflow(-int(res)):
                return 0
            else:
                return -int(res)
        
def is_overflow(x):
    if x < -2147483648 or x > 2147483648:
        return 1
    else:
        return 0
