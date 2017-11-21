#include<string.h>
#include<stdio.h>
int  main()
{
    char a[100],b[100];
    char *link(char *,char *);
    gets(a);
    gets(b);
    link(a,b);
    puts(a);
    printf("刘丽斐独立完成\n");
}
char *link(char *s1,char *s2)
{
    //将s1与s2所指向的字符串交叉连接，生成的新字符串放在s1所指的数组中
    int len1 = strlen(s1), len2 = strlen(s2);
    char c[200];
    int k=0;
    int i=0;
    if(len1 < len2) {
        for(i = 0; i < len1; i++) {
            c[k ++] = s1[i];
            c[k ++] = s2[i];
        }
        while(s2[i] != '\0') {
        	c[k ++] = s2[i];
        	i ++;
		}
    }
    else {
        for(i = 0; i < len2; i++) {
            c[k ++] = s1[i];
            c[k ++] = s2[i];
        }
        while(s1[i]) {
        	c[k ++] = s1[i];
        	i ++;
		}
    }
    for(i = 0; i < len1 + len2; i++)
        s1[i] = c[i];
    s1[len1+len2] = '\0';
    return s1;
}
