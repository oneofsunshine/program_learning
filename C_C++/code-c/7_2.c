#include <stdio.h>
#include <math.h>
void trans(double x, int k) { //��ʮ����ת��Ϊk����, ��������; 
	int a, b, len = -1, inte, integer[20], decimal[9], isPos, i;
	double deci;
	
	if(x > 0)
		isPos = 1;
	else {
		isPos = 0;
		x = -x;
	}
	
	inte = floor(x);
	deci = x - inte;
	
	b = inte;
	inte = inte * k;
	do {
		a = b % k;
		len ++;
		b = (b - a) / k;
		inte = inte / k;
		integer[len] = a;
	} while( inte / k > 0);
	
	if(isPos == 0)
		printf("-");
	for(; len >= 0; len--)  {
		if(integer[len] > 9)
			printf("%c", integer[len] + 55);
		else
			printf("%d", integer[len]);
	}
	if(deci) 
		printf(".");
	
	len = 0;
	while(deci != 0.0f && len < 10) {
		deci = deci * k;
		a = floor(deci);
		decimal[len] = a;
		len ++;
		deci -= a;
	}
	
	for(i = 0; i < len; i ++) {
		if(decimal[i] > 9)
			printf("%c", decimal[i] + 55);
		else
			printf("%d", decimal[i]);
	}
	printf("\n");
}
int main() 
{
	double x;
	printf("������һ��ʮ��������");
	scanf("%lf", & x);
	printf("%-13.6lf�Ķ��������ǣ�", x);
	trans(x, 2);
	printf("%-13.6lf�İ˽������ǣ�", x);
	trans(x, 8);
	printf("%-11.6lf��ʮ���������ǣ�", x);
	trans(x, 16);
	printf("����쳶������");
	return 0;
}
