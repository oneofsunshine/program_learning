#include <stdio.h>
int main()
{
	double sum = 0.0;
	int i, n;
	printf("Enter n: ");
	scanf("%d", &n);
//	¿€º”(-1)^n*(1.0)/(1+3*n);
	for(i = 0; i < n; i ++) {
		if(i % 2) 
			sum += -1 * 1.0 / (1 + 3 * i);
		else
			sum += 1.0 / (1 + 3 * i);
	}
	
	printf("sum=");
	printf("%.3lf", sum);
	
	return 0;
}
