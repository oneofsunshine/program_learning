#include <iostream>
using namespace std;
template<class T>
class Complex
{
public:
	T real, imag;
	Complex() { };
	Complex(T r, T i):real(r), imag(i) { };
	Complex operator+(const Complex & c) {
		return Complex(real + c.real, imag + c.imag);
	}
	Complex operator*(const Complex & c) {
		Complex tmp1(real * c.real, real * c.imag);
		Complex tmp2(-(imag * c.imag), imag * c.real);
		return (tmp1 + tmp2);
	}
	friend istream & operator>>(istream & is, Complex & c) {
		is >> c.real >> c.imag;
		return is;
	}
	friend ostream & operator<<(ostream & os, Complex c) {
		os << c.real << "+" << c.imag <<"i";
		return os;
	}
};
int main()
{
	Complex<int> a, b;
	//Complex<double> a, b;
	cout << "Input a1,a2,b1,b2:";
	cin >> a >> b;
	cout << "(" << a << ")*(" << b << ")=" << a * b;
	return 0;
}
