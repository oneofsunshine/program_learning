#include <stdio.h>
#include <math.h>
int isprime(int x)
{
	int i;
    for(i = 2; i <= sqrt(x); i++) {
        if(x % i == 0)
            return 0;
    }
    return 1;
}

int convert(int x)
{
    int result = 0;
    int tmp;
    while(x > 0) {
        tmp = x % 10;
        result = result * 10 + tmp;
        x /= 10;
    }
    return result;
}

int main()
{
    int n, i;
    printf("请输入一个整数:");
    scanf("%d", & n);
    for(i = 2; i < n; i++) {
    	if( isprime(convert(i)) && isprime(i))
    		printf("%d ", i);
	}
	printf("\n刘丽斐独立完成\n");
    return 0;
}
