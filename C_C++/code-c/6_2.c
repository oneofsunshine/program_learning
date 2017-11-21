#include <stdio.h>
#include <string.h>
#define N 21
int main()
{
	char num[21][13];
	int score[21];
	int i, j, findScore = -1;                  //findScore����Ҫ���ҵ�ѧ�ŵĳɼ�  Not findʱfindScoreΪ-1 
	char searchID[13];                         //Ҫ���ҵ�ѧ�� 
	FILE * pr=fopen("studentlist.txt","r");    //��ָ���ļ�
	
	int low, high, mid;                        //�۰����ʱ�� 
	char tmp[13];                              //����ʱ��
	int temp;                                  //����ʱ�� 
	
    if(pr==NULL)                               //�����ļ��Ƿ�ɹ�
    {
        puts("Can't open studentlist.txt");
        return 0;
    }
	for(i = 0; i < N; i ++)
    	fscanf(pr,"%s%d",num[i],&score[i]);    //��������
    
    printf("        student ID      score\n"); 
    printf("-----------------------------------\n");
    for(i = 0; i < N; i ++) {
    	printf("%+19s", num[i]);
    	printf("%7d\n", score[i]);
    }
    printf("Input the searching ID:");
    scanf("%s", &searchID);
    
    //˳�����
//	for(i = 0; i < N; i ++) {
//		if(strcmp(num[i], searchID) == 0)
//			findScore = score[i];
//	}
	
	//�۰���� 
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
    	
    //����
    for(i = 0; i < N - 1; i ++) {
    	for(j = 1; j < N - i; j ++) {
    		if(score[j - 1] < score[j]) { //�Գɼ��������� 
    			//�����ɼ� 
    			temp = score[j - 1];
    			score[j - 1] = score[j];
    			score[j] = temp;
    			
    			//����ѧ�� 
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
    
    fclose(pr);                                //�ر��ļ� 

	return 0;
}
