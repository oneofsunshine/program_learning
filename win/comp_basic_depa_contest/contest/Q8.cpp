#include <iostream>
#include <cmath>
#include <cstdio>
using namespace std;
int isPrime(int n)
{
	if(n < 2)
		return 0;
	for(int i =2; i <= sqrt(n); i++) {
		if(n % i == 0)
			return 0;
	}
	return 1;
}
void out(int n)
{
	int tmp1 = 2, tmp2 = 2;
	while(tmp1 + tmp2 != n && tmp2 < n) {
		for))
		tmp2 = isPrime();
	}
	printf("4d%=2d%+2d%", n, tmp1, tmp2);
}
int main()
{
	int num = 1;
	int flag = 0;
	for(int i = 6; i <= 100; i++) {
		if(i % 2 == 0) {
			out(i);
			num++;
			flag =1;
		}		
		if(num % 5 == 1 && flag) {
			cout << endl;
			flag = 0;
		}
	}
	return 0;
}