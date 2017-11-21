#include <stdio.h>
int baoshu(int n ,int p[ ] )
{
	int next = 0; //下一个要存入数组的位置 
	int i, count;
	int pre[n], suc[n]; //存储前后位置 
	int before, after, cur = 0; 
	
	//初始化第i位前后指向的位置 
	for(i = 0; i < n - 1; i ++) {
		suc[i] = i + 1;
		pre[i + 1] = i;
	}
	suc[n - 1] = 0;
	pre[0] = n - 1;

	while(1) {
		// 找到要出列的位置 
		for(count = 0; count < 2; count ++)
			cur = suc[cur];
			
		after = suc[cur]; //after代表当前位后一位 
		before = pre[cur]; //before代表当前位前一位 
		
		p[next] = cur + 1; //退出序号存入数组 
		next++;
		
		suc[before] = after; //退出位置前一位的后一位指向退出位置退出前的后一位
		pre[after] = before; //退出位置后一位的前一位指向退出位置退出前的前一位
		
		//如果退出位置前一位和后一位是相同位置报数结束 
		if(before == after)
			break;
		
		cur = after; //若未结束，进行下一次报数，cur退出，下次报数从cur后一位开始 
	}
	p[n - 1] = before + 1; //将最后出列者存入数组
	return before + 1; //返回最后出列者 
}
int main()
{
	int m, a[1000], i, num;
	printf("人数：");
	scanf("%d", & m);     //此处的m要小于等于1000
	num = baoshu(m, a);
	printf("最后退出的序号是：%d\n", num);
	puts("退出的顺序是：");
	for(i = 0; i < m; i ++)
		printf("%d ", a[i]);
	printf("\n");
	return 0;
}
