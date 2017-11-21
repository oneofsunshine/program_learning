#include <iostream>
#include <cstdio>
#include <math.h>
using namespace std;
int main()
{
	double sum = 0;
	for(int i = 100; i <= 1000; i++)
		sum += sqrt(i);
	printf("sum=%.2lf", sum);
	return 0;
}