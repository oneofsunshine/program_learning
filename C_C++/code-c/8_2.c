#include <stdio.h> 
# define N 10
int  main( ) {
	int delnum(int *a , int num , int n);
	int a[N], i, num, m;
	printf("请输入要删除的数字：");
	scanf("%d", & num);
	//键盘输入N个数到数组a中;
	printf("请输入10个数字：");
	for(i = 0; i < N; i ++)
		scanf("%d", & a[i]);
	m = delnum(a, num, N);//函数调用，在数组a中删除指定的数num，并返回剩余数据个数;
	//输出删除了num后的数组a;
	for(i = 0; i < m; i ++) {
		printf("%d ", a[i]);
	}
	return 0;
}
int delnum(int *a , int num , int n)
{
	int i, j = 0;
	for(i = 0; i < n; i ++) {
		if(num != a[i])
			a[j ++] = a[i];
	}
	return j;
}
//定义并编写delnum函数
//用于在长度是n的数组a中，删除一个值为num的元素。
//删除后数组的长度作为函数的返回值返回。
//注意，num在数组中可能不只一个。 
