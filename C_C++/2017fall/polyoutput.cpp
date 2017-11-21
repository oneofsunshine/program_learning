#include<iostream>
#include<cstdio>
using namespace std;
string format(int a, int x)
{
    string s;
    if(x == 0) {
        if(a != 0) {
            char tmp[5];
            sprintf(tmp, "%d", a);
            return tmp;
        }
        else 
            return "";
    }
    else if(x == 1) {
        if(a == -1)
            return "-x";
        else if(a == 0)
            return "";
        char tmp[5];
        sprintf(tmp, "%d", a);
        return string(tmp) + "x";
    }
    else
        s = "x^";
    if(a == 1) {
        char tmp[5] = {};
        sprintf(tmp,"%d", x);  ;
        return s + tmp;
    }
    else if(a == 0)
        return "";
    else if(a == -1) {
        char tmp[5] = {};
        sprintf(tmp,"%d", x);  ;
        return "-" + s + tmp; 
    }
    else {
        char tmp1[5], tmp2[5];
        sprintf(tmp1, "%d", a);
        sprintf(tmp2, "%d", x);
        return tmp1 + s + tmp2;
    }
}
int main()
{
    int n;
    cin >> n;
    int a[n+1];
    for(int i = 0; i <= n; i ++)
        cin >> a[i];
    for(int i = 0; i <= n; i ++) {
        if(i == 0 || a[i] <= 0)
            cout << format(a[i], n-i);
        else
            cout << "+" + format(a[i], n-i);
    }
    return 0;
}
