#include<stdio.h>
#include<cstdlib>
#include<algorithm>

int radix_sort(int *, int);

struct node{
	int value;
	node* next;
};

int main()
{
    int n;
    scanf("%d", &n);
	int src[n];

	for(int i=0; i<n; i++)
        scanf("%d", &src[i]);

	radix_sort(src, n);

	//std::sort(src,src+MAXN);
	//输出排序后的
	for(int i=0; i<n; i++)
		printf("%d ", src[i]);
	printf("\n");

	/**检查排序结果*/
	for(int i=0; i<n-1; i++){
		if(src[i] > src[i+1])
		{
			printf("wrong\n");
		}
	}
	return 0;
}

/**
 * 基数排序
 * 用链表实现
 */
int radix_sort(int *src, int size){
	node* headers[10];
	node* rears[10];
	node* bigHeader=NULL;
	node* bigRear=NULL;

	/**
	 * 把数组化为链表，方便后续处理
	 */
	for(int i=0; i<size; i++)
	{
		node *tmp = new node;
		tmp->value = src[i];
		tmp->next = NULL;
		if(bigRear == NULL)
		{
			bigHeader = tmp;
			bigRear = tmp;
		}else{
			bigRear->next = tmp;
			bigRear = tmp;
		}
	}

	/**
	 * 最外层循环的次数与最大的数位数相同
	 */
	for(int s=1; ; s*=10)
	{
		int max=0;
		/**
		 * 解决某些指针问题，可以无视
		 */
		for(int i=0; i<10; i++){
			headers[i] = NULL;
			rears[i] = NULL;
		}

		/** 按照第n+1位(s=10^n)进行分类
		 *
		 */
		for(int i=0; i<size; i++)
		{
			if(bigHeader->value/s > max)
			{
				max = bigHeader->value/s;
			}
			int n=(bigHeader->value/s) % 10;
			if(headers[n] == NULL)
			{
				headers[n] = rears[n] = bigHeader;
			}else
			{
				rears[n]->next = bigHeader;
				rears[n] = bigHeader;
			}
			bigHeader = bigHeader->next;
			rears[n]->next = NULL;
		}
		//麻烦的指针^-^
		bigRear = NULL;

		/** 从第一个分链表开始依次加到大链表中
		 *
		 */
		for(int i=0; i<10; i++)
		{
			while(headers[i] != NULL)
			{
				if(bigHeader == NULL)
				{
					bigHeader = bigRear = headers[i];
				}else
				{
					bigRear->next = headers[i];
					bigRear = headers[i];
				}
				headers[i] = headers[i]->next;
				bigRear->next = NULL;
			}
		}

		//已经处理到了最大长度的那个数
		if(max <= 10)
			break;

		/** 输出每次循环后的结果
		 *
		 */
		for(node *tmp = bigHeader; tmp != NULL; tmp = tmp->next)
		{
			printf("%d ", tmp->value);
		}
		printf("\n");
	}

	/**
	 * 将链表中的数写回数组
	 * 不要忘了释放new的链表
	 */
	int i=0;
	for(node *tmp = bigHeader; tmp != NULL; )
	{
		src[i++] = tmp->value;
		tmp = tmp->next;
		delete bigHeader;
		bigHeader = tmp;
	}

	return 0;
}
