#include<iostream>
using namespace std;
int trans(int n, int k)
{
    int res = 0, len = 0, inte[20];
	while(n > 0) {
		inte[len] = n % k;
        n /= k;
        len ++;
    }
    for(int i = len - 1; i >= 0; i --)
        if(inte[i] == 1)
            res ++;
    return res;
}
int main()
{
    int n, k;
    cin >> n >> k;
    // trans(n, k);
    cout << trans(n, k);
    return 0;
}
