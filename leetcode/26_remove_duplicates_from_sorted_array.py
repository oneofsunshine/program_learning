class Solution:
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        i = 0    
        for j in range(1, len(nums)):
            if nums[j] != nums[i]:
                i = i + 1
                nums[i] = nums[j]
        return len(set(nums))