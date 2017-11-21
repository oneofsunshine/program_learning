#include<iostream>
#include<cmath>
using namespace std;
struct poly {
    int coef; //系数
    int expom; //指数
};
int value(int n, poly * p, int x)
{
    int res = 0;
    for (int i = 0; i < n; i ++) {
        int tmp = pow(x, p[i].expom);
        res += p[i].coef * tmp;
    }
    return res;
}
int main()
{
    int n, x;
    cin >> n;
    poly p_list[n];
    for (int i = 0; i < n; i ++)
        cin >> p_list[i].coef >> p_list[i].expom;
    cin >> x;
    cout << value(n, p_list, x);
    return 0;
}
