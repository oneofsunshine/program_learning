/*************************************************************************
	> File Name: coClock.cpp
	> Author: 
	> Mail: 
	> Created Time: 2017年02月05日 星期日 11时33分48秒
 ************************************************************************/

#include<iostream>
#include<memory>
#include<cstring>
#include<algorithm>
#include<string>
#define N 32
using namespace std;
void SetBit(char & c)
{
    if(c == '0')
        c = '1';
    else
        c = '0';
}
void Change(char switchs[], int i, int length)
{
    if( i - 1 >= 0)
        SetBit(switchs[i - 1]);
    SetBit(switchs[i]);
    if(i + 1 < length)
        SetBit(switchs[i+1]);
}
int main()
{
    char oriswitchs[N];
    char switchs[N];
    char aim[N];
    int num1 = 0, num2 = 0, length = 0;
    int min_num = 0;
    bool tag = false;
    cin>> oriswitchs>> aim;
    length = strlen(oriswitchs);
    for(int k = 0; k < 2; k++)
    {
        memcpy(switchs, oriswitchs, sizeof(oriswitchs));
        if(k)
        {
            for(int i = 1; i < length; ++i )
            {
                if(switchs[i-1] != aim[i-1])
                {
                    Change(switchs, i , length);

                    ++num1;
                }
            }
            if(switchs[length -1] == aim[length - 1])
                tag = true;
        }
        else
        {
            Change(switchs, 0, length);
            ++num2;
            for(int j = 1; j < length; ++j)
            {
                if(switchs[j - 1] != aim[j -1])
                {
                    Change(switchs, j ,length);
                    ++ num2;
                }
            }
            if( switchs[length - 1] == aim[length - 1])
                tag = true;
        }
    }
    if(tag)
    {
        min_num = min(num1, num2);
        cout<<min_num;
    }
    else
    {
        cout<<"impossible";
    }
    return 0 ;
}
