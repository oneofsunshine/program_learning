#include<iostream>
using namespace std;
int main()
{ 
    int num;
    cin>>num;
    int result = 0;
    for(num; num != 0; num /= 10)
    {
        int l = num % 10;
        result = result * 10 + l;
    }
    cout<<result;
    return 0;
}
