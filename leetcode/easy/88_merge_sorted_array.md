### Merge Sorted Array

#### 1. Description:

>Given two sorted integer arrays *nums1* and *nums2*, merge *nums2* into *nums1* as one sorted array.
>
>**Note:**
>
>You may assume that *nums1* has enough space (size that is greater or equal to *m* + *n*) to hold additional elements from *nums2*. The number of elements initialized in *nums1* and *nums2* are *m* and *n* respectively.

#### 2. Solution(code):

```python
class Solution:
    def merge(self, nums1, m, nums2, n):
        """
        :type nums1: List[int]
        :type m: int
        :type nums2: List[int]
        :type n: int
        :rtype: void Do not return anything, modify nums1 in-place instead.
        """
        nums1[m:] = nums2[:n]
        nums1.sort()
```

#### 3.Analysis:

**体会:** 利用python切片特性，体会语言特性