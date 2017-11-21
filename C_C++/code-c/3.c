#include <stdio.h>
#include <math.h>
int isPrime(int n)
{
	int i;
	if(n < 2)
		return 0;
	for(i =2; i <= sqrt(n); i++) {
		if(n % i == 0)
			return 0;
	}
	return 1;
}
int main()
{
	int x, k, i, count = 0;
	scanf("%d%d", &x, &k);
	for(i = x + 1; ; i ++) {
		if(isPrime(i)) {
			printf("%d ", i);
			count ++;
		}
		if(count >= k)
			break;
	}
	return 0;
}
