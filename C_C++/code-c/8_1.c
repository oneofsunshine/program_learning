#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define N 21
int main() {
	void input(char (*p_id)[13],int *p_score,int n);
	void sort(char (*p_id)[13],int *p_score,int n);
	void output(char (*p_id)[13],int *p_score,int n);
	char num[N][13];          //����ѧ������
	int score[N];             //����ɼ�����
	int i;
	input(num,score,21);
	/*����input�����ļ�studentlist.txt�ж�ȡ21��ѧ����ѧ����ɼ���ʵ��ѧ������num�ͳɼ�����score��*/
	puts("\tstudent ID\tscore\n-----------------------------------");
	for(i=0; i<N; i++)
		printf("\t%s\t%d\n",num[i],score[i]);  //��ʾѧ����ɼ�
	sort(num,score,21);
	//����sort������ʵ�ְ��ɼ����������������ݣ�ͬʱͬ������ѧ��˳��
	puts("==================sort==============");
	puts("\tstudent ID\tscore\n");
	for(i=0; i<N; i++)
		printf("\t%s\t%d\n",num[i],score[i]);  //�ٴ���ʾ�����ѧ����ɼ�
	output(num,score,21);   //�������������ݵ�ָ���ļ�studentlist_De.txt��
	return 0;
}
//�������ļ�studentlist.txt�ж�ȡ21��ѧ����ѧ����ɼ����β�p_ID��ָ��Ķ�άcharѧ��������
//p_score��ָ���һά�ɼ�������
void input(char (*p_id)[13],int *p_score,int n) {
	FILE * pr=fopen("studentlist.txt","r");
	int i = 0;
	if(pr == NULL) {                             //�����ļ��Ƿ�ɹ�
		puts("Can't open studentlist.txt");
		exit(0);
	}
	//while(fscanf(pr,"%s%d", (p_id + i), (p_score + i)) >=0 ) i++; //˼�������i�Ƕ������ݸ��� 
	for(i = 0; i < n; i ++)
		fscanf(pr,"%s%d", (p_id + i), (p_score + i));    //��������
	fclose(pr);                                //�ر��ļ�
}
//��p_score��ָ��ĳɼ��������򣨽��򣩣�ͬʱͬ�����Ķ�Ӧ���β�p_ID��ָ���ѧ������˳��
void sort(char (*p_id)[13],int *p_score,int n)
{
	int i, j, temp;
	char tmp[13];
	for(i = 0; i < n - 1; i ++) {
		for(j = 1; j < n - i; j ++) {
			if(p_score[j - 1] < p_score[j]) { //�Գɼ���������
				//�����ɼ�
				temp = p_score[j - 1];
				p_score[j - 1] = p_score[j];
				p_score[j] = temp;

				//����ѧ��
				strcpy(tmp, p_id[j - 1]);
				strcpy(p_id[j - 1], p_id[j]);
				strcpy(p_id[j], tmp);
			}
		}
	}
}
//����������������������ļ�studentlist_De.txt�С���ɺ��ļ�studentlist_De.txt�������£�
void output(char (*p_id)[13], int *p_score, int n)
{
	FILE * pr;
    int i;
    pr = fopen("studentlist_De.txt", "w");
    if(pr == NULL) {
        puts("Can't creat studentlist_De.txt");
        exit(0);
    }
    for(i = 0; i < n; i ++)
        fprintf(pr, "%s %d\n", p_id[i], p_score[i]);
	fclose(pr);                                //�ر��ļ�	
}
