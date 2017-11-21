#include<iostream>
using namespace std;
class Base
{
    public:
    int i;
    int f;
    int l;
    virtual void print() { }
};
class Derived:public Base
{
    public:
    int n;
    int m;
    //int p;
    virtual void print() { }
};
int main()
{
    cout << sizeof(Base::i) << endl;
    cout << sizeof(int) << " " << sizeof(Base) << " " << sizeof(Derived) << endl;
    //cout << sizeof(int) <<" " << sizeof(Base) - sizeof(Base::i)<< " " << sizeof(Derived)  - sizeof(Derived::i) - sizeof(Derived::n)<< endl;
    return 0;
}
