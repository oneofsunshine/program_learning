#include <iostream>
#include <cmath>
#include <cstdio>
using namespace std;
bool isPrime(int n)
{
	if(n < 2)
		return 0;
	for(int i =2; i <= sqrt(n); i++) {
		if(n % i == 0)
			return 0;
	}
	return 1;
}
int main()
{
	int num = 1;
	int m, n;
	int flag = 0;
	cout <<"Input m: ";
	cin >> m;
	cout <<"Input n: ";
	cin >> n;
	for(int i = m; i <= n; i++) {
		if(isPrime(i)) {
			printf("%4d" ,i);
			num ++;
			flag = 1;
		}
		if(num % 6 == 1 && flag) {
			cout << endl;
			flag = 0;
		}
			
	}
	//cout <<endl;
	return 0;
}