#include <stdio.h>	
int main()
{
	void findmax(int a[]);
	void swap(int a[5][6]);
	int i, j;
	int arr[5][6];
	for(i = 0; i < 5; i ++)
		for(j = 0; j < 6; j ++)
			scanf("%d", &arr[i][j]);
	for(i = 0; i < 5; i ++)
		findmax(arr[i]);
	swap(arr);
	for(i = 0; i < 5; i ++) {
		for(j = 0; j < 6; j ++)
			printf("%5d ", arr[i][j]);
		printf("\n");
	}
	return 0;
}
void findmax(int a[6])
{
	int tmp = 0, i;
	for(i = 1; i < 6; i ++)
		if(a[i] > a[tmp]) tmp = i;
	
	i = a[5];
	a[5] = a[tmp];
	a[tmp] = i;
}
void swap(int a[5][6])
{
	int i, j, max;
	int tmp[6];
	
	for(i = 0; i < 5; i ++) {
		max = i;
		for(j = i; j < 5; j ++) {
			if(a[j][5] > a[max][5])
				max = j;
		}
		for(j = 0; j < 6; j ++)
			tmp[j] = a[i][j];
		for(j = 0; j < 6; j ++)
			a[i][j] = a[max][j];
		for(j = 0; j < 6; j ++)
			a[max][j] = tmp[j];
	}
}
