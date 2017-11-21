#include <stdio.h>
#include <string.h>
int main()
{
	char s1[100], s2[100];
	printf("the first string:");
	scanf("%s", s1);
	printf("the second string:");
	scanf("%s", s2);
	char * loc = strstr(s1, s2);
	
	while(loc != NULL) {
		int len1 = strlen(loc);
		int len2 = strlen(s2);
		int i = 0;
		while(i < (len1 - len2)) {
			loc[i] = loc[i + len2];
			i++;
		}
		loc[len1 - len2] = '\0';
		loc = strstr(s1, s2);
	}
	printf("%s\n", s1);
	return 0;
}
