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
    printf("������20������");
	for(i = 0; i < N; i ++)
		scanf("%d", & a[i]); 
		//a[i] = i + 1;
		
     //������N������ֵ������ͨ���������룬��������ļ��ж��������������
    for(i = 0; i < N; i ++)           //�����������������
        printf("%d ", a[i]);
    puts("");
    printf("Please input delete num:");
    scanf("%d", & num);           //����Ҫɾ������
    len = delnum(a, N, num);      //���ú�����������a��ɾ��num������ʣ�����ݸ���
    for(i = 0; i < len; i ++)        //���ɾ�������������
        printf("%d ", a[i]);    //ע�⣬����ֻ���len������
    puts("");
    return 0;
}
