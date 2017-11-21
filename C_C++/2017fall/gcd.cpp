/*************************************************************************
	> File Name: gcd.cpp
	> Author: Yuan Hao
	> Mail:begin20160801@gmail.com 
	> Created Time: 2017年08月19日 星期六 11时55分05秒
 ************************************************************************/

#include<iostream>
using namespace std;
int gcd(int m, int n) {
    if(n == 0)
        return m;
    return gcd(n, m % n);
}
int main()
{
    int M, N;
    while(cin >> M >> N) {
        cout << gcd(M, N) << endl;
    }
    return 0;
}
