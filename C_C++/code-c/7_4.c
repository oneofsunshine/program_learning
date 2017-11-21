#include<stdio.h>
#include<stdlib.h>
#define N 20
int delnum(int p[], int n, int num)
{
	int left = n;
	int i, j;
	for(i = 0; i < N; i ++) {
		if(p[i] == num) {
			for(j = i; j < left - 1; j ++)
				p[j] = p[j + 1];
			left --;
		}
	}
	return left;
}
int main()
{
    int a[N], num, len, i;
    printf("请输入20个数：");
	for(i = 0; i < N; i ++)
		scanf("%d", & a[i]); 
		//a[i] = i + 1;
		
     //给数据N个数赋值，可以通过键盘输入，或从数据文件中读出，或随机产生
    for(i = 0; i < N; i ++)           //输出数据中所有数据
        printf("%d ", a[i]);
    puts("");
    printf("Please input delete num:");
    scanf("%d", & num);           //输入要删除的数
    len = delnum(a, N, num);      //调用函数，从数组a中删除num，返回剩余数据个数
    for(i = 0; i < len; i ++)        //输出删除后的数组数据
        printf("%d ", a[i]);    //注意，这里只输出len个数据
    puts("");
    return 0;
}
