class Solution:
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 1:
            return nums[0]
        tmp1 = nums[0]
        tmp2 = nums[0] 
        for i in nums[1:]:
            tmp1 = max(tmp1 + i, i)
            tmp2 = max(tmp1, tmp2)
        return tmp2
