#include <stdio.h>
int baoshu(int n ,int p[ ] )
{
	int next = 0; //��һ��Ҫ���������λ�� 
	int i, count;
	int pre[n], suc[n]; //�洢ǰ��λ�� 
	int before, after, cur = 0; 
	
	//��ʼ����iλǰ��ָ���λ�� 
	for(i = 0; i < n - 1; i ++) {
		suc[i] = i + 1;
		pre[i + 1] = i;
	}
	suc[n - 1] = 0;
	pre[0] = n - 1;

	while(1) {
		// �ҵ�Ҫ���е�λ�� 
		for(count = 0; count < 2; count ++)
			cur = suc[cur];
			
		after = suc[cur]; //after����ǰλ��һλ 
		before = pre[cur]; //before����ǰλǰһλ 
		
		p[next] = cur + 1; //�˳���Ŵ������� 
		next++;
		
		suc[before] = after; //�˳�λ��ǰһλ�ĺ�һλָ���˳�λ���˳�ǰ�ĺ�һλ
		pre[after] = before; //�˳�λ�ú�һλ��ǰһλָ���˳�λ���˳�ǰ��ǰһλ
		
		//����˳�λ��ǰһλ�ͺ�һλ����ͬλ�ñ������� 
		if(before == after)
			break;
		
		cur = after; //��δ������������һ�α�����cur�˳����´α�����cur��һλ��ʼ 
	}
	p[n - 1] = before + 1; //���������ߴ�������
	return before + 1; //������������ 
}
int main()
{
	int m, a[1000], i, num;
	printf("������");
	scanf("%d", & m);     //�˴���mҪС�ڵ���1000
	num = baoshu(m, a);
	printf("����˳�������ǣ�%d\n", num);
	puts("�˳���˳���ǣ�");
	for(i = 0; i < m; i ++)
		printf("%d ", a[i]);
	printf("\n");
	return 0;
}
