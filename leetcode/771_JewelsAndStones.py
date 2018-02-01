class Solution:
    def numJewelsInStones(self, J, S):
        """
        :type J: str
        :type S: str
        :rtype: int
        """
        i = 0
        for s in S:
            if s in J:
                i = i + 1
        return i
