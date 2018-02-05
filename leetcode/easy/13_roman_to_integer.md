### Roman to Integer 

#### 1. Description:

> Given a roman numeral, convert it to an integer.
>
> Input is guaranteed to be within the range from 1 to 3999.

#### 2. Solution (code):
```c++
class Solution {
public:
    int romanToInt(string s) {
        int res = 0;
        vector<int> nums;
        for(int i = 0; i < s.length(); i ++) {
            switch(s[i]) {
                case 'I': nums.push_back(1); break;
                case 'V': nums.push_back(5); break;
                case 'X': nums.push_back(10); break;
                case 'L': nums.push_back(50); break;
                case 'C': nums.push_back(100); break;
                case 'D': nums.push_back(500); break;
                case 'M': nums.push_back(1000); break;
                default: cout << "error" << endl;
            }
        }
        if(nums.size() == 1) return nums[0];
        for(int i = 0; i < nums.size() - 1; i ++) {
            if(nums[i] < nums[i + 1]) {
                res += nums[i + 1] - nums[i];
                i ++;
            }
            else
                res += nums[i];
            if(i == nums.size() - 2 && nums[i] >= nums[i + 1])
                res += nums[i + 1];
        }
        return res;
    }
};
```
