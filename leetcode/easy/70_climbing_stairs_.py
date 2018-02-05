class Solution:
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 1:
            return 1
        elif n == 2:
            return 2
        else:
            arr = []
            for i in range(n + 1):
                arr.append(0)
            
            arr[1] = 1
            arr[2] = 2
            for i in range(3, n + 1):
                arr[i] = arr[i - 1] + arr[i - 2]
            return arr[n]
