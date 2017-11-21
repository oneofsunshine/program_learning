#include <iostream>
#include <cmath>
#include <cstdio>
using namespace std;
double fact(int n)
{
	double result = 1;
	for(int i = 1; i <= n; i++) {
		result *= i;
	}
	return result;
}
int main()
{
	int n;
	cout << "Enter n: ";
	cin >> n;
	for(int i= 1; i <= n; i ++) {
		cout << i << "!=" << fact(i) << endl;
	}
	return 0;
}