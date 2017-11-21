#include <stdio.h>
#include <string.h>
int main()
{
	char c[100];
	int num = 0, i;
	int flag = 0;
	gets(c);
	for(i = 0; c[i] != '\0'; i ++) {
		if((c[i] == ' ' || c[i] == ',' || c[i] == '.') && flag) {
			flag = 0;
		}
		else if(((c[i] >= 'a' && c[i] <= 'z') || (c[i] >= 'A' && c[i] <= 'Z') || c[i] > '0' && c[i] < '9') && !flag) {
			num ++;
			flag = 1;
		}
	}
	printf("%d", num);
	return 0;
}
