#include <iostream>
#include <string>
using namespace std;

class A {
	int n;
	public:
    A() {}
    A(int i):n(i) {}
    A operator++(int ) {
        A old(n);
        n = n + 1;
        return old;
    }
    A & operator++() {
        n = n+1;
        return *this;
    }
    friend ostream & operator<<(ostream & is, const A a) {
        is << a.n;
        return is;
    }
    operator int() {
        return n;
    }
// 在此处补充你的代码
};

class B {
	private:
	static int k;
	static int Square(int n)
	{
		cout <<  "k=" << k <<endl;
		return n * n;
	}
	friend int main();
};
int B::k;

int main()
{
	A a1(1),a2(2);
	cout << a1++ << endl;
	(++a1) = 100;
	cout << a1 << endl;
	cout << ++ a1 << endl;
	cout << a1 << endl;
	int n;
	cin >> n;
	while( n --) {
        cin >> B::k;
		A a3(B::k);
		cout << B::Square(a3) << endl;
	}
	return 0;
}
/*
第一行是整数n，表示第二行有n个整数。
第二行：n个整数。

所有整数都在 0 和100之间
输出
先输出：
1
100
101
101

对于输入中第二行的每个整数x，输出两行：
第一行：k=x；
第二行：x的平方。
样例输入
3
3 4 5
样例输出
1
100
101
101
k=3
9
k=4
16
k=5
25
*/
