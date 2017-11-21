#include<stdio.h>
#include<stdlib.h>
#include<string.h>
char s[2001][1001];
int cmp(const void *a,const void *b) {
    return strcmp((char *)a,(char *)b);
}
using namespace std;
int main()
{
    int i,n;
    scanf("%d",&n);
    getchar();
    for(i = 0; i <n ;i ++) gets(s[i]);
    qsort(s,n,1001*sizeof(char),cmp);
    for(i = 0; i < n; i ++) puts(s[i]);
    return 0;
}
