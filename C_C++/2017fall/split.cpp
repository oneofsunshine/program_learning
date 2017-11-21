/*************************************************************************
	> File Name: split.cpp
	> Author: Yuan Hao
	> Mail:begin20160801@gmail.com 
	> Created Time: 2017年08月19日 星期六 12时24分54秒
 ************************************************************************/

#include<iostream>
using namespace std;
int split(int n) {
    int result = 1;
    for(int i = 2; i < n; i ++) {
        result += n / i;
    }
    return result;
}
int main()
{
    int N;
    while(cin >> N)
        cout << split(N) << endl;
    return 0;
}
