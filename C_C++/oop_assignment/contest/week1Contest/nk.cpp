#include<iostream>
using namespace std;
int factorial(int n)
{
    if(n == 1)
        return 1;
    else
        return n * factorial(n-1);

}
int main()
{
    int n,k,result = 1;
    cin>>n>>k;
    n =  factorial(n);
    while (k)
    {
        result *= n;
        k--;
    }
    cout<<result;
}
