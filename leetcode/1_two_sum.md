### Two Sum with C++

#### 1. Description:

> Given an array of integers, return **indices** of the two numbers such that they add up to a specific target.
>
> You may assume that each input would have **exactly** one solution, and you may not use the *same* element twice.

#### 2.Example:

```json
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
```

#### 3. Solution (code):

```c++
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> result;
        for(int i = 0; i < nums.size(); i ++) {
            for(int j = i + 1; j < nums.size(); j ++) {
                if(nums[i] + nums[j] == target) {
                    result.push_back(i);
                    result.push_back(j);
                }
            }
        }
        return result;
    }
};
```

#### 4. Analysis:

**算法时间复杂度:** O(n^2)

**题目大意:** 从给出的一个数组，从中找出和为给定值的两个数，返回两数的下标

**解题思路:** 按冒泡排序顺序寻找和为给定值的两个数，将两数存入结果数组

**体会:** 问题简单，但也需要对stl的vector用法有简单了解，本体思路可考虑修改排序算法解决。