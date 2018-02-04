class Solution:
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        length = len(digits)
        digits[length -1] = digits[length -1] + 1
        
        for i in range(length)[::-1]:
            if digits[i] == 10:
                if i != 0:
                    digits[i] = 0
                    digits[i - 1] = digits[i - 1] + 1
                else:
                    digits[0] = 0
                    digits.insert(0, 1)
                        
        return digits
