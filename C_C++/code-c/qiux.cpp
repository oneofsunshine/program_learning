#include<iostream>
#include<stdio.h>
#define K 0.04700
using namespace std;
int main()
{
	double l = 1000.00;
	for(int i = 0; i < 10; i++ )
	{
		l = l *(1 + K);
		printf("%d: %f\n",i+1,l);
		cout<<i + 1<<": "<<l<<endl;
		l += 1000.00;
	}
	return 0;
}
