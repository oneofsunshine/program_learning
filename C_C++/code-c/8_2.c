#include <stdio.h> 
# define N 10
int  main( ) {
	int delnum(int *a , int num , int n);
	int a[N], i, num, m;
	printf("������Ҫɾ�������֣�");
	scanf("%d", & num);
	//��������N����������a��;
	printf("������10�����֣�");
	for(i = 0; i < N; i ++)
		scanf("%d", & a[i]);
	m = delnum(a, num, N);//�������ã�������a��ɾ��ָ������num��������ʣ�����ݸ���;
	//���ɾ����num�������a;
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
//���岢��дdelnum����
//�����ڳ�����n������a�У�ɾ��һ��ֵΪnum��Ԫ�ء�
//ɾ��������ĳ�����Ϊ�����ķ���ֵ���ء�
//ע�⣬num�������п��ܲ�ֻһ���� 
