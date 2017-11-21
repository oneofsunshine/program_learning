#include <iostream>
using namespace std;
int main()
{
	int x, n;
	cout << "Enter x: ";
	cin >> x;
	cout << "Enter n: ";
	cin >> n;
	int t = x;
	for(int i = 1 ; i < n; i ++)
		x *= t;
	cout << "result=" << x;
	return 0;
}