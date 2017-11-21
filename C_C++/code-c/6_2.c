#include <stdio.h>
#include <string.h>
#define N 21
int main()
{
	char num[21][13];
	int score[21];
	int i, j, findScore = -1;                  //findScore代表要查找的学号的成绩  Not find时findScore为-1 
	char searchID[13];                         //要查找的学号 
	FILE * pr=fopen("studentlist.txt","r");    //打开指定文件
	
	int low, high, mid;                        //折半查找时用 
	char tmp[13];                              //排序时用
	int temp;                                  //排序时用 
	
    if(pr==NULL)                               //检查打开文件是否成功
    {
        puts("Can't open studentlist.txt");
        return 0;
    }
	for(i = 0; i < N; i ++)
    	fscanf(pr,"%s%d",num[i],&score[i]);    //读出数据
    
    printf("        student ID      score\n"); 
    printf("-----------------------------------\n");
    for(i = 0; i < N; i ++) {
    	printf("%+19s", num[i]);
    	printf("%7d\n", score[i]);
    }
    printf("Input the searching ID:");
    scanf("%s", &searchID);
    
    //顺序查找
//	for(i = 0; i < N; i ++) {
//		if(strcmp(num[i], searchID) == 0)
//			findScore = score[i];
//	}
	
	//折半查找 
	low = 0; high = N -1;
	while(low != high) {
		mid = (low + high) / 2; 
		if(mid == low || mid == high)
			break;
		
		if(strcmp(num[mid], searchID) > 0)
			high = mid;
		else if(strcmp(num[mid], searchID) < 0)
			low = mid;
		else {
			findScore = score[mid];
			break;
		}
	}
		
	if(findScore == -1)
		printf("Not find\n");
	else
    	printf("score=%d\n", findScore);
    	
    //排序
    for(i = 0; i < N - 1; i ++) {
    	for(j = 1; j < N - i; j ++) {
    		if(score[j - 1] < score[j]) { //以成绩降序排列 
    			//交换成绩 
    			temp = score[j - 1];
    			score[j - 1] = score[j];
    			score[j] = temp;
    			
    			//交换学号 
				strcpy(tmp, num[j - 1]);
				strcpy(num[j - 1], num[j]);
				strcpy(num[j], tmp);
			}
		}
	}
	 
    printf("==================sort==============\n");
    printf("        student ID      score\n\n"); 
    for(i = 0; i < N; i ++) {
    	printf("%+19s", num[i]);
    	printf("%7d\n", score[i]);
    }
    
    fclose(pr);                                //关闭文件 

	return 0;
}
