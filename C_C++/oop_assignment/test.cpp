#include<iostream>
using namespace std;
class A
{
    public:
    virtual void fun() {
        cout<<"A::fun()"<<endl;
    }
    virtual void Do() { };
};
class B:public A
{
    public:
    void fun() {
        A::fun();
        cout<<"B::fun()"<<endl;
    }
    void Do(){
        cout<<"B::Do()"<<endl;
    }
};
class C:public A
{
    public:
    void fun() {
        A::fun();
        cout<<"C::fun()"<<endl;
    }
};
int main()
{
    A * a;
    A * a1;
    B b;
    C c;
    a = new B;
    a1 = new C;
    a->Do();
    a1->fun();
    return 0;
}
