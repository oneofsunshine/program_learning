#include <iostream>
#include <cstring>
#include <cstdlib>
using namespace std;
class Complex {
private:
    double r,i;
public:
    void Print() {
        cout << r << "+" << i << "i" << endl;
    }
    Complex() { }
    Complex(const char c[5]) {
        r = (double)(c[0] - 48);
        i = (double)(c[2] - 48);
    }
    Complex & operator= (const Complex & c) {
        r = c.r;
        i = c.i;
        return * this;
    }
};
int main() {
    Complex a;
    a = "3+4i"; a.Print();
    a = "5+6i"; a.Print();
    return 0;
}
