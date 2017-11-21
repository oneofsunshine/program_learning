#include<iostream>
#include<cstring>
using namespace std;
class Integer {
    public:
    int a[101];
    int len;
    Integer() {}
    Integer(string s) {
        for(int i = 0; i < 101; i++)
            a[i] = 0;
        len = s.length();
        int k = 0;
        while(s[k] != '\0') {
            a[k] = (int)(s[len - 1 - k] - '0');
            k++;
        }
    }
    friend ostream & operator<<(ostream & os, const Integer & hi) {
        for(int i = hi.len - 1; i >= 0; i--)
            os<<hi.a[i];
        return os;
    }
    Integer operator+ (const Integer & hi2) {
        Integer h;
        h.len = (len>hi2.len)?len:hi2.len;
        for(int i = 0; i < h.len; i++) {
            h.a[i] = a[i] + hi2.a[i];
        }
        for(int i = 0; i < h.len - 1; i ++) {
            if(h.a[i] > 10) {
                h.a[i + 1] += 1;
                h.a[i] -= 10;
            }
        }
        if(h.a[len - 1] > 10) {
            h.a[len - 1] -= 10;
            h.a[len] = 1;
            h.len ++;
        }
        return h;
    }
};
int main()
{
    string a,b;
    char o;
    cin>>a>>o>>b;
    /*switch(o) {
        case '+':cout<<a+b;break;
        case '-':cout<<a-b;break;
        case '*':cout<<a*b;break;
        case '/':cout<<a/b;break;
        default:cout<<"wrong input";
    }*/
    Integer hugeInt1(a),hugeInt2(b);
    cout<<a<<o<<b<<endl;
    cout<<hugeInt1 + hugeInt2<<endl;
    return 0;
}
