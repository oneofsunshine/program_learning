#include<iostream>
#include<cmath>
using namespace std;
int main()
{
	int n;
	cout << "Enter n: ";
	cin >> n;
	for(int i =0; i <= n; i ++)
		cout << "pow(3," << i << ")=" << pow(3,i) << endl;
	return 0;
} 
