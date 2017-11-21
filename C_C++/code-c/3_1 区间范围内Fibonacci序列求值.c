#include <stdio.h>
int fib(int k)
{
	if(k <= 2)
		return 1;
	else
		return fib(k-1) + fib(k-2);
}
int main()
{
	int m, n, i;
	int num = 0;
	int fibon[30];
	scanf("%d%d", &m, &n);
	for(i = 1; fib(i) <= n; i ++) {
		if(fib(i) >= m)
			fibon[num ++] = i;
	}
	printf("%d fib:", num);
	for(i = 0; i < num; i ++)
		printf("%d ", fib(fibon[i]));
	return 0;
}
