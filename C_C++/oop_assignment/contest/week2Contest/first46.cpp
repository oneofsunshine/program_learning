#include <iostream>
using namespace std;
class A {
        int val;
    public:
        A(int n) { val = n; }
        int GetVal() { return val; }
};
class B: public A {
    private:
        int val;
    public:
        B(int n):val(n+2),A(n+4) { }
        int GetVal() { return val; }
};
int main() {
    B b1(2);
    cout << b1.GetVal() << "," << b1.A::GetVal() << endl;
    return 0;
}
